package users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.model.Result;
import users.api.hexagonal.users.api.hexagonal.adapter.out.persistence.repository.entity.UserEntity;
import users.api.hexagonal.users.api.hexagonal.common.mapper.AddressMapper;

import java.time.LocalDateTime;

@Mapper(uses = AddressMapper.class)
public interface RandomUserMapper {

    @Mapping(target = "username", source = "result.login.username")
    @Mapping(target = "password", source = "result.login.password")
    @Mapping(target = "createdOn", expression = "java(getNow())")
    @Mapping(target = "updatedOn", expression = "java(getNow())")
    @Mapping(target = "email", source = "result.email")
    @Mapping(target = "firstName", source = "result.name.firstName")
    @Mapping(target = "lastName", source = "result.name.lastName")
    @Mapping(target = "phoneNumber", source = "result.phoneNumber")
    UserEntity toEntity(Result result);

    default LocalDateTime getNow() {
        return LocalDateTime.now();
    }
}
