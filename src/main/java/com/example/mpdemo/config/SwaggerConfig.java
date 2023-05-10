package com.example.mpdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 告诉Spring容器，这个类是一个配置类
@EnableSwagger2 // 启用Swagger2功能
public class SwaggerConfig {
    /**
     * 配置Swagger2相关的bean
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))// com包下所有API都交给Swagger2管理
                .paths(PathSelectors.any()).build();
    }

    /**
     * 此处主要是API文档页面显示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("标题——演示项目API") // 标题
                .description("描述——演示项目") // 描述
                .version("版本——1.0") // 版本
                .build();
    }
}



//package com.example.helloworld.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
////@Configuration
//////@EnableWebMvc
//////@EnableOpenApi
////public class SwaggerConfig {
////
////    @Bean
////    public Docket applicationAPI(){
////        return new Docket(DocumentationType.OAS_30)
////                .enable(true)
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("com.example.helloworld.controller"))
////                .paths(PathSelectors.any())
////                .build()
////                .apiInfo(myApi());
////    }
////
////    private ApiInfo myApi(){
////        return new ApiInfoBuilder().title("师大2班项目服务接口")
//////                .contact(new Contact("my","http://www.baidu.com","123qq.com"))
////                .version("1.1")
////                .description("接口调用及测试文档")
////                .build();
////    }
////
////}
//
//@Configuration
////@EnableSwagger2 //swagger3版本不需要使用这个注解，当然写上也无所谓~
//public class SwaggerConfig {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)  // swagger2版本这里是DocumentationType.SWAGGER_2
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("xxx管理平台")
//                .description("xxx管理平台 API接口文档")
//                .license("xxx有限公司")
//                .licenseUrl("xxx")
//                .version("1.0")
//                .build();
//    }
//}
