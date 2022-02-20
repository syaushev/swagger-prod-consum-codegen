package com.steering.swaggerconsumer.config;

import com.steering.restaurant.dishes.ApiClient;
import com.steering.restaurant.dishes.api.DishControllerApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfig {
    @Bean
    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        return apiClient.setBasePath("http://localhost:8080");
    }

    @Bean
    public DishControllerApi dishControllerApi() {
        return new DishControllerApi();
    }
}
