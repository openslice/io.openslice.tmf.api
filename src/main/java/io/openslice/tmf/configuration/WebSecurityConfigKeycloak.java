/*-
 * ========================LICENSE_START=================================
 * io.openslice.portal.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.configuration;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Profile("!testing")
public class WebSecurityConfigKeycloak {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, ServerProperties serverProperties,
			@Value("${origins:[]}") String[] origins, @Value("${permit-all:[]}") String[] permitAll,
			AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver) throws Exception {

		http.oauth2ResourceServer(oauth2 -> oauth2.authenticationManagerResolver(authenticationManagerResolver));

		// Enable and configure CORS
		http.cors(cors -> cors.configurationSource(corsConfigurationSource(origins)));

		// State-less session (state in access-token only)
		http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Disable CSRF because of state-less session-management
		http.csrf(csrf -> csrf.disable());

		// Return 401 (unauthorized) instead of 302 (redirect to login) when
		// authorization is missing or invalid
		http.exceptionHandling(eh -> eh.authenticationEntryPoint((request, response, authException) -> {
			response.addHeader(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Restricted Content\"");
			response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
		}));

		// If SSL enabled, disable http (https only)
		if (serverProperties.getSsl() != null && serverProperties.getSsl().isEnabled()) {
			http.requiresChannel(channel -> channel.anyRequest().requiresSecure());
		}

		// @formatter:off
        http.authorizeHttpRequests(requests -> requests
            //.requestMatchers(permitAll).permitAll()
            .anyRequest().permitAll());
        // @formatter:on

		return http.build();
	}

	private UrlBasedCorsConfigurationSource corsConfigurationSource(String[] origins) {
		final var configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(origins));
		configuration.setAllowedMethods(List.of("*"));
		configuration.setAllowedHeaders(List.of("*"));
		configuration.setExposedHeaders(List.of("*"));

		final var source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Data
	@Configuration
	@ConfigurationProperties(prefix = "spring-addons")
	static class SpringAddonsProperties {
		private IssuerProperties[] issuers = {};

		@Data
		static class IssuerProperties {
			private URL uri;

			@NestedConfigurationProperty
			private ClaimMappingProperties[] claims;

			private String usernameJsonPath = JwtClaimNames.SUB;

			@Data
			static class ClaimMappingProperties {
				private String jsonPath;
				private CaseProcessing caseProcessing = CaseProcessing.UNCHANGED;
				private String prefix = "";

				static enum CaseProcessing {
					UNCHANGED, TO_LOWER, TO_UPPER
				}
			}
		}

		public IssuerProperties get(URL issuerUri) throws MisconfigurationException {
			final var issuerProperties = Stream.of(issuers).filter(iss -> issuerUri.equals(iss.getUri())).toList();
			if (issuerProperties.size() == 0) {
				throw new MisconfigurationException(
						"Missing authorities mapping properties for %s".formatted(issuerUri.toString()));
			}
			if (issuerProperties.size() > 1) {
				throw new MisconfigurationException(
						"Too many authorities mapping properties for %s".formatted(issuerUri.toString()));
			}
			return issuerProperties.get(0);
		}

		static class MisconfigurationException extends RuntimeException {
			private static final long serialVersionUID = 5887967904749547431L;

			public MisconfigurationException(String msg) {
				super(msg);
			}
		}
	}

	@RequiredArgsConstructor
	static class JwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<? extends GrantedAuthority>> {
		private final SpringAddonsProperties.IssuerProperties properties;

		@Override
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Collection<? extends GrantedAuthority> convert(Jwt jwt) {
			
			
			return Stream.of(properties.claims).flatMap(claimProperties -> {
				Object claim;
				try {
					claim = JsonPath.read(jwt.getClaims(), claimProperties.jsonPath);
				} catch (PathNotFoundException e) {
					claim = null;
				}
				if (claim == null) {
					return Stream.empty();
				}
				if (claim instanceof String claimStr) {
					return Stream.of(claimStr.split(","));
				}
				if (claim instanceof String[] claimArr) {
					return Stream.of(claimArr);
				}
				if (Collection.class.isAssignableFrom(claim.getClass())) {
					final var iter = ((Collection) claim).iterator();
					if (!iter.hasNext()) {
						return Stream.empty();
					}
					final var firstItem = iter.next();
					if (firstItem instanceof String) {
						return (Stream<String>) ((Collection) claim).stream();
					}
					if (Collection.class.isAssignableFrom(firstItem.getClass())) {
						return (Stream<String>) ((Collection) claim).stream()
								.flatMap(colItem -> ((Collection) colItem).stream()).map(String.class::cast);
					}
				}
				return Stream.empty();
			}) /* Insert some transformation here if you want to add a prefix like "ROLE_" or force upper-case authorities */

					.map(s -> "ROLE_" + s)
					.map(SimpleGrantedAuthority::new)
					.map(GrantedAuthority.class::cast).toList();
		}
	}

	@Component
	@RequiredArgsConstructor
	static class SpringAddonsJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
		private final SpringAddonsProperties springAddonsProperties;

		@Override
		public AbstractAuthenticationToken convert(Jwt jwt) {
			final var issuerProperties = springAddonsProperties.get(jwt.getIssuer());
			final var authorities = new JwtGrantedAuthoritiesConverter(issuerProperties).convert(jwt);
			final String username = JsonPath.read(jwt.getClaims(), issuerProperties.getUsernameJsonPath());
			return new JwtAuthenticationToken(jwt, authorities, username);
		}
	}

	@Bean
	AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver(
			SpringAddonsProperties addonsProperties, SpringAddonsJwtAuthenticationConverter authenticationConverter) {
		final Map<String, AuthenticationManager> authenticationProviders = Stream.of(addonsProperties.getIssuers())
				.map(SpringAddonsProperties.IssuerProperties::getUri).map(URL::toString)
				.collect(Collectors.toMap(issuer -> issuer,
						issuer -> authenticationProvider(issuer, authenticationConverter)::authenticate));
		return new JwtIssuerAuthenticationManagerResolver(
				(AuthenticationManagerResolver<String>) authenticationProviders::get);
	}

	JwtAuthenticationProvider authenticationProvider(String issuer,
			SpringAddonsJwtAuthenticationConverter authenticationConverter) {
		JwtDecoder decoder = JwtDecoders.fromIssuerLocation(issuer);
		var provider = new JwtAuthenticationProvider(decoder);
		provider.setJwtAuthenticationConverter(authenticationConverter);
		return provider;
	}
}

//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
//@Profile("!testing")
//public class WebSecurityConfigKeycloak extends KeycloakWebSecurityConfigurerAdapter  {
//	
// 
//
//    @Autowired
//    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//
//    @Autowired
//    public void configureGlobal(
//      AuthenticationManagerBuilder auth) throws Exception {
//  
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider
//         = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(
//          new SimpleAuthorityMapper());
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }
// 
//    @Bean
//    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
// 
//    @Bean
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(
//          new SessionRegistryImpl());
//    }
//    
////
////    @Override
////    @Bean("authenticationManager")
////    public AuthenticationManager authenticationManagerBean() throws Exception {
////        return super.authenticationManagerBean();
////    }
//
//    //see also https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        // @formatter:off
//		http.authorizeRequests()
////		.antMatchers("/sessions/**").permitAll()
////		.antMatchers("/register/**").permitAll()
////		//.antMatchers("/sessions/logout").permitAll()
////		.antMatchers("/categories/**").permitAll()
////		.antMatchers("/experiments/**").permitAll()
////		.antMatchers("/vxfs/**").permitAll()
////		.antMatchers("/login").permitAll()
////		.antMatchers("/images/**").permitAll()
////		.antMatchers("/packages/**").permitAll()
////		.antMatchers("/testweb/**").permitAll()		
////		.antMatchers("/oauth/token/revokeById/**").permitAll()
////		.antMatchers("/tokens/**").permitAll()
////		.antMatchers("/actuator/**").permitAll()
////		.antMatchers("/swagger/**").permitAll()
////		.antMatchers("/v2/**").permitAll()
////		.antMatchers("/swagger-ui.html").permitAll()
////		.antMatchers("/webjars/**").permitAll()
////		.antMatchers("/swagger-resources/**").permitAll()
//		//.antMatchers("/admin/**").permitAll()//.hasAnyRole("admin","user","ROLE_admin","ROLE_user")
//		
//		.anyRequest().permitAll()
//		//.and().formLogin().permitAll()
//		.and().csrf().disable()
//		//.cors().and().csrf().disable() // we use the filter..see below
//		.exceptionHandling()
//	    .authenticationEntryPoint(restAuthenticationEntryPoint)
//	    .and()
//		.logout();
//		// @formatter:on
//    }
//    
//
//    @Bean
//	public FilterRegistrationBean corsFilter() {
//
//	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true);
//	    config.setAllowedOriginPatterns(Collections.singletonList("*"));
//	    config.addAllowedHeader("*");
//	    config.addAllowedMethod("*");
//	    config.addAllowedOriginPattern( "*" );
//	    source.registerCorsConfiguration("/**", config);
//	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//
//	    bean.setOrder(0);
//
//	    return bean;
//
//	}
//
//
//
//}
