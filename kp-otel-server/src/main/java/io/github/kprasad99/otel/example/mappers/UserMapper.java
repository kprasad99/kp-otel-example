package io.github.kprasad99.otel.example.mappers;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import io.github.kprasad99.otel.example.r2dbc.domain.User;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toDomain(io.github.kprasad99.otel.example.service.model.User user);

	io.github.kprasad99.otel.example.service.model.User toModel(User user);
}
