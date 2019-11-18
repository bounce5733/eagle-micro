package com.eagle.micro.app.demo.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagle.micro.app.demo.infrastructure.persistence.po.AddressPO;

public interface JpaAddressPORepository extends JpaRepository<AddressPO, Long> {

}
