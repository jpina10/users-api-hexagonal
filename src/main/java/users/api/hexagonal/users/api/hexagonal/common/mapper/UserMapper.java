package users.api.hexagonal.users.api.hexagonal.common.mapper;

import org.mapstruct.Mapper;
import users.api.hexagonal.users.api.hexagonal.adapter.in.rest.dto.UserDto;
import users.api.hexagonal.users.api.hexagonal.adapter.out.persistence.entity.UserEntity;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

@Mapper(uses = AddressMapper.class)
public interface UserMapper {
    User toModel(UserEntity entity);

    UserEntity toEntity(User user);

    UserDto toDto(User user);
}
