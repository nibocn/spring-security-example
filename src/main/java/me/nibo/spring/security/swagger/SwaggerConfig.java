package me.nibo.spring.security.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置
 * @author NiBo
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan({"me.nibo."})
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hanboard.platform.controller"))
//                .paths(PathSelectors.any())
//                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful APIs")
                .description("使用 Swagger2 构建 RESTful APIs 文档")
                .contact(new Contact("NiBo", "", "nibocn@gmail.com"))
                .version("1.0")
                .build();
    }
}
