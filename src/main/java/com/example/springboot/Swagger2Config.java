package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类(在与springboot项目集成时，需放在Application启动类统计目录下)
 * 通过@Configuration注解加载该配置
 * 通过@EnableSwagger2启动swagger2
 *(http://localhost:8081/swagger-ui.html)
 * @author caojianyi@dxy.cn
 * @date 2021-04-10 22:57
 * @Description
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    /**
     * 创建api应用
     * apiInfo()增加api相关信息
     * 通过select函数返回一个包含ApiSelectorBuilder实例,用来控制那些接口暴露给swagger来展示
     * 本例采用指定扫描的包路径 来定义指定要简历api的目录
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springboot.controller"))//扫描哪些包下的接口
                .paths(PathSelectors.any()).build();

    }


    /**
     * 创建API的基本信息 这些基本信息会展示在文档页面中
     * 访问路径:http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo  apiInfo(){
        return new ApiInfoBuilder().title("springboot项目Restful apis")
                .description("cjy学习使用")
                .termsOfServiceUrl("http://localhost:8081/")//swagger路径
                .contact("long")
                .version("1.0").build();

    }
}
