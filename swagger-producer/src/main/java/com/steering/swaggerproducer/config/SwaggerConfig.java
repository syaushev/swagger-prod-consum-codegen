package com.steering.swaggerproducer.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    private static final String API_VERSION = "v1";

    private Docket createDocketV2(final String groupName, final String title, final String description, final String basePackage) {
        return createDocketV2(groupName, title, description, RequestHandlerSelectors.basePackage(basePackage));
    }

    private Docket createDocketV2(final String groupName, final String title, final String description,
                                  final Predicate<RequestHandler> predicateRequestHandler) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .select()
                .apis(predicateRequestHandler)
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title(title)
                        .description(description)
                        .version(API_VERSION)
                        .build())
                .forCodeGeneration(true);
    }

    @Bean
    public Docket testDocket() {
        return createDocketV2("Restaurant",
                "Restaurant API", "Restaurant API",
                "com.steering.swaggerproducer");
    }
}
