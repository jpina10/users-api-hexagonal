package users.api.hexagonal.users.api.hexagonal.common.mapper;

import org.mapstruct.Mapper;
import users.api.hexagonal.users.api.hexagonal.adapter.out.persistence.repository.entity.AddressEntity;
import users.api.hexagonal.users.api.hexagonal.application.model.address.Address;

@Mapper
public interface AddressMapper {

    Address toModel(AddressEntity addressEntity);
}
