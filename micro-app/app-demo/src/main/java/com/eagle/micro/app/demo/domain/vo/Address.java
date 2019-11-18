package com.eagle.micro.app.demo.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
