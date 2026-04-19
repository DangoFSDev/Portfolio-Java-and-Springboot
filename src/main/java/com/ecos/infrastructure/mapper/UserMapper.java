package com.ecos.infrastructure.mapper;

import com.ecos.application.dto.response.UserResponse;
import com.ecos.domain.model.User;
import com.ecos.infrastructure.entity.UserEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserEntity toEntity(User dto);

    UserResponse toResponse(User dto);

}
