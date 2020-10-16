package cn.kgc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Author:wxc
 * project: springboot_zongJie
 * ClassName: SwaggerConfig
 * Date: 2020/8/13 20:43 周四
 * yy:猥琐别浪，等我发育。
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo());
//
//    }
}
