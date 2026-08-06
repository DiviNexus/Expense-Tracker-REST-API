package com.divija.expensetracker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // tells spring that this class contains application configuration.
public class OpenAPIConfig {
    // to customize Swagger (API Documentation) page with your Details!

    @Bean   // Spring says: "If a method is marked with @Bean, I'll execute it once and keep the returned object."
    public OpenAPI expenseTrackerOpenAPI() { // So, this method returns exactly one configured OpenAPI object.

        return new OpenAPI()
                .info(new Info()
                        .title("Expense Tracker REST API")
                        .description("A Spring Boot REST API for managing personal expenses.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Divija")
                                .email("divija@example.com")));
    }
}
