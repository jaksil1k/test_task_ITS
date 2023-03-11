package com.example.test_task.mapper;

import com.example.test_task.dto.LocationShareDto;
import com.example.test_task.entity.LocationShare;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LocationShareMapper {
    LocationShareMapper MAPPER = Mappers.getMapper(LocationShareMapper.class);

    LocationShare toEntity(LocationShareDto locationShareDto);


}
