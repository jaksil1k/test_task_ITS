package com.example.test_task.mapper;

import com.example.test_task.dto.LocationDto;
import com.example.test_task.entity.Location;
import com.example.test_task.entity.LocationShare;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LocationMapper {
    LocationMapper MAPPER = Mappers.getMapper(LocationMapper.class);

    @Mapping(target = "locationShares", ignore = true)
    @Mapping(target = "users", ignore = true)
    List<LocationDto> toDto(List<Location> locations);
}
