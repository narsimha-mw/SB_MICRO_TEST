//package com.retailer.place.order.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//
//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.retailer.place.order.controller"))
////                .paths(PathSelectors.ant("/api/v2/.*"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(copyRight());
//    }
//
//    private ApiInfo copyRight() {
//        return new ApiInfoBuilder()
//                .title("Order_services REST API")
//                .description("For testing purpose..")
//                .contact(new Contact("Narsimha","https://localhost:2000","snlshvsnj@gmail.com"))
//                        .license("All right @2023")
//                .licenseUrl("https://localhost:2000")
//                .version("v2_0.1")
//                .build();
//
//    }
//}
