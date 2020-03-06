/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
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
package io.openslice.tmf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import io.openslice.tmf.configuration.RestAuthenticationEntryPoint;

/**
 * 
    The prePostEnabled property enables Spring Security pre/post annotations
    The securedEnabled property determines if the @Secured annotation should be enabled
    The jsr250Enabled property allows us to use the @RoleAllowed annotation

 * @author ctranoris
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,  securedEnabled = true, jsr250Enabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//    
//
//    @Autowired
//    private DataSource dataSource;
//

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    
    
   
    //see also https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
		http.authorizeRequests()
		.antMatchers( "/serviceCatalogManagement/**").permitAll()
		.antMatchers( "/resourceCatalogManagement/**").permitAll()
		.antMatchers( "/party/**").permitAll()
		.antMatchers( "/swagger*", "/v2/**").permitAll()
		.antMatchers("/swagger/**").permitAll()
		.antMatchers("/swagger-resources/**").permitAll()
		.antMatchers("/webjars/**").permitAll()		
		.antMatchers("/v2/**").permitAll()
		.antMatchers("/**").permitAll() //for now let it open
		.anyRequest().authenticated()
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
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

	    bean.setOrder(0);

	    return bean;

	}

}
