package com.eagle.micro.app.demo.application.api.request;

import lombok.Getter;
import lombok.Setter;

/**
 * api请求参数如果为对象 放在application.api.request包中
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 16:49
 * @Version 1.0
 **/
@Setter
@Getter
public class AddUserRequestDTO {

    private String name;

    private String province;

    private String city;

    private String detail;
}
