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


import java.util.Collections;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
@Profile("!testing")
public class WebSecurityConfigKeycloak extends KeycloakWebSecurityConfigurerAdapter  {
	
 

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    public void configureGlobal(
      AuthenticationManagerBuilder auth) throws Exception {
  
        KeycloakAuthenticationProvider keycloakAuthenticationProvider
         = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(
          new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }
 
    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
 
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(
          new SessionRegistryImpl());
    }
    
//
//    @Override
//    @Bean("authenticationManager")
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    //see also https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
		http.authorizeRequests()
//		.antMatchers("/sessions/**").permitAll()
//		.antMatchers("/register/**").permitAll()
//		//.antMatchers("/sessions/logout").permitAll()
//		.antMatchers("/categories/**").permitAll()
//		.antMatchers("/experiments/**").permitAll()
//		.antMatchers("/vxfs/**").permitAll()
//		.antMatchers("/login").permitAll()
//		.antMatchers("/images/**").permitAll()
//		.antMatchers("/packages/**").permitAll()
//		.antMatchers("/testweb/**").permitAll()		
//		.antMatchers("/oauth/token/revokeById/**").permitAll()
//		.antMatchers("/tokens/**").permitAll()
//		.antMatchers("/actuator/**").permitAll()
//		.antMatchers("/swagger/**").permitAll()
//		.antMatchers("/v2/**").permitAll()
//		.antMatchers("/swagger-ui.html").permitAll()
//		.antMatchers("/webjars/**").permitAll()
//		.antMatchers("/swagger-resources/**").permitAll()
		//.antMatchers("/admin/**").permitAll()//.hasAnyRole("admin","user","ROLE_admin","ROLE_user")
		
		.anyRequest().permitAll()
		//.and().formLogin().permitAll()
		.and().csrf().disable()
		//.cors().and().csrf().disable() // we use the filter..see below
		.exceptionHandling()
	    .authenticationEntryPoint(restAuthenticationEntryPoint)
	    .and()
		.logout();
		// @formatter:on
    }
    

    @Bean
	public FilterRegistrationBean corsFilter() {

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.setAllowedOriginPatterns(Collections.singletonList("*"));
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    config.addAllowedOriginPattern( "*" );
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

	    bean.setOrder(0);

	    return bean;

	}



}
