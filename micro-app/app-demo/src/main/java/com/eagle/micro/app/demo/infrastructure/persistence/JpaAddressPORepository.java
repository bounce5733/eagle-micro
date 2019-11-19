package com.eagle.micro.app.demo.infrastructure.persistence;

import com.eagle.micro.app.demo.infrastructure.persistence.po.AddressPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAddressPORepository extends JpaRepository<AddressPO, Long> {

}
