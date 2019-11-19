package com.eagle.micro.app.demo.domain.vo;

import lombok.*;

/**
 * 值对象放在domain.vo中
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

	private String province;

	private String city;

	private String detail;
}
