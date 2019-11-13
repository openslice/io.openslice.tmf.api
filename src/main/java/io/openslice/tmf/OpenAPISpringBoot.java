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

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * For implementing the callback and events, it might be useful to check the DDD pattern: https://www.baeldung.com/spring-data-ddd
 * 
 * 
 * @author ctranoris
 *
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { 

		"io.openslice",
		"io.openslice.sd",
		"io.openslice.sd.model",
		"io.openslice.tmf",  
		"io.openslice.tmf.configuration", 
		"io.openslice.tmf.scm633", 
		"io.openslice.tmf.scm633.api",
		"io.openslice.tmf.scm633.repo", 
		"io.openslice.tmf.scm633.reposervices",
		"io.openslice.tmf.scm634", 
		"io.openslice.tmf.scm634.api"})
@EntityScan( basePackages = { 
		"io.openslice",
		"io.openslice.sd",
		"io.openslice.sd.model",
		"io.openslice.tmf",  
		"io.openslice.tmf.configuration", 
		"io.openslice.tmf.scm633", 
		"io.openslice.tmf.scm633.api",
		"io.openslice.tmf.scm633.repo", 
		"io.openslice.tmf.scm633.reposervices",
		"io.openslice.tmf.scm634", 
		"io.openslice.tmf.scm634.api"} )

public class OpenAPISpringBoot implements CommandLineRunner {

    private static ApplicationContext applicationContext;
    
    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
      
        applicationContext =  new SpringApplication(OpenAPISpringBoot.class).run(args);
        
//        for (String beanName : applicationContext.getBeanDefinitionNames()) {
//            System.out.println(beanName);
//        }
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
   
}
