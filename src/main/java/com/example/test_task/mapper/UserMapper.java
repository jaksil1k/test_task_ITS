package com.example.test_task.mapper;

import com.example.test_task.dto.UserDto;
import com.example.test_task.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "location_shares", ignore = true)
    @Mapping(target = "friends", ignore = true)
    @Mapping(target = "locations", ignore = true)
    List<UserDto> toDto (List<User> users);
}
