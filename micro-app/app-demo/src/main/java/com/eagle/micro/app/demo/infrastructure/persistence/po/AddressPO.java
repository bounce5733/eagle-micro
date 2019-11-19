package com.eagle.micro.app.demo.infrastructure.persistence.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "address")
@ToString
public class AddressPO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long userId;

	@Column
	private String province;

	@Column
	private String city;

	@Column
	private String detail;

}
