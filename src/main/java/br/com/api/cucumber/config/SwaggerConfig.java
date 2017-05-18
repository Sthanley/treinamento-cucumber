package br.com.api.cucumber.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        		.groupName("cucumber")
        		  .apiInfo(apiInfo())
        		  .select()
        		  .apis(RequestHandlerSelectors.any())
        		  .paths(PathSelectors.ant("/api/v1/cucumber/*"))
        		  .build()
        		  .pathMapping("/");                                          
    }
    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
    	  .title("Cucumber API")
    	  .description("REST Cucumber API")
    	  .version("1.0")
    	  .build();
    }
}