package com.eagle.micro.app.demo.infrastructure.persistence.assembler.mapper;

import com.eagle.micro.app.demo.domain.vo.Address;
import com.eagle.micro.app.demo.infrastructure.persistence.po.AddressPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressPOMapper {

	AddressPOMapper INTANCE = Mappers.getMapper(AddressPOMapper.class);

	@Mappings({ @Mapping(target = "id", ignore = true), @Mapping(target = "userId", ignore = true) })
	AddressPO fromAddress(Address address);

}
