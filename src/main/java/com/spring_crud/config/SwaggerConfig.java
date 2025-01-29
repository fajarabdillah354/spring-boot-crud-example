package com.spring_crud.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    /**
     * kita bisa mengecek default path dengan http://localhost:8080/v3/api-docs
     * atau kalo kita mau masuk ke swagger docnya bisa menggunakan http://localhost:8080/swagger-ui.html
     * @return
     */

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info().title("Crud Example Documentation").version("0.1"));
    }

}
