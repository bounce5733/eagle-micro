package com.eagle.micro.app.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger2
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 17:16
 * @Version 1.0
 **/
@Configuration
public class SwaggerConfiguration {

    @Value("${swagger.flag:true}")
    private boolean swaggerFlag;

    @Value("${eureka.instance.metadata-map.version}")
    private String version;

    /**
     * swagger文档声明
     *
     * @return Docket
     */
    @Bean
    public Docket swaggerPersonApi10() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("version").description("版本字段不要改").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue(version).build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2).enable(swaggerFlag).select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build().globalOperationParameters(pars).apiInfo(new ApiInfoBuilder().version("1.0").title("userServer API")
                        .description("Documentation userServer API v1.0").build());
    }
}
