package com.eagle.micro.app.demo.infrastructure.persistence.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class UserPO {

	@Id
	private Long id;

	@Column
	private String name;

}
