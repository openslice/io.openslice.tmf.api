package io.openslice.tmf.scm;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
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
		String a = ( new File("../io.openslice.portal.web/src/")).getAbsoluteFile().toURI().toString()  ;
		System.out.println("======================> " + a);
		registry.addResourceHandler("/testweb/**")
				.addResourceLocations( a ) //"file:///./../io.openslice.portal.web/src/")
				.setCachePeriod(0)
				.resourceChain(true)
				.addResolver(new EncodedResourceResolver())
				.addResolver(new PathResourceResolver());
		
		registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
	
	

}