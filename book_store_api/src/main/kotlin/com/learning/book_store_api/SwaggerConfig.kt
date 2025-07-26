package com.learning.book_store_api


import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("dev")
class SwaggerConfig {
    // No additional configuration needed with Springdoc 2.2+
    // Access Swagger UI at: http://localhost:8080/swagger-ui.html
}
