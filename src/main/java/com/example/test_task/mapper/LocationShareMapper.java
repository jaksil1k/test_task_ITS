package com.example.test_task.mapper;

import com.example.test_task.dto.LocationShareDto;
import com.example.test_task.entity.LocationShare;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationShareMapper {
    LocationShareMapper MAPPER = Mappers.getMapper(LocationShareMapper.class);


    @Mapping(source = "user", target = "email", ignore = true)
    @Mapping(source = "location", target = "locationId", ignore = true)
    @Mapping(source = "sharedUser", target = "sharedUserEmail", ignore = true)
    LocationShareDto toDto(LocationShare locationShare);


}
