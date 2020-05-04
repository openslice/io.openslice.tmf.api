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

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	Environment env;

	public MvcConfig() {
		super();
	}

	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/index.html");

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/testweb/**").addResourceLocations("file:///C:/Users/ctranoris/git/io.openslice.portal.web/src/").setCachePeriod(0);
		String a = (new File("../io.openslice.tmf.web/dist/io-openslice-portal-web/")).getAbsoluteFile().toURI().toString();
		System.out.println("======================> " + a);
		registry.addResourceHandler("/services/**").addResourceLocations(a) // "file:///./../io.openslice.portal.web/src/")
				.setCachePeriod(0).resourceChain(true).addResolver(new EncodedResourceResolver())
				.addResolver(new PathResourceResolver());

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
		// HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
		LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(formatter);
		LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(formatter);

		JavaTimeModule module = new JavaTimeModule();
		module.addSerializer(LocalDateTime.class, localDateTimeSerializer);
		module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(module);

		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(OffsetDateTime.class, new JsonSerializer<OffsetDateTime>() {
			@Override
			public void serialize(OffsetDateTime offsetDateTime, JsonGenerator jsonGenerator,
					SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
				jsonGenerator.writeString(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(offsetDateTime));

			}
		});
		
		
		
		
		mapper.registerModule(simpleModule);

		// add converter at the very front
		// if there are same type mappers in converters, setting in first mapper
		// is used.
		converters.add(0, new MappingJackson2HttpMessageConverter(mapper));
		
		
		
	}
	
	
}
