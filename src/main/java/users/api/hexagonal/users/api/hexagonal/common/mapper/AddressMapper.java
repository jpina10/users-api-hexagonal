package users.api.hexagonal.users.api.hexagonal.common.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.model.Location;
import users.api.hexagonal.users.api.hexagonal.adapter.in.rest.dto.AddressDto;
import users.api.hexagonal.users.api.hexagonal.application.model.address.Address;

@Mapper
public interface AddressMapper {

    @Mapping(target = "street", source = "createAddressDto.street.name")
    @Mapping(target = "number", source = "createAddressDto.street.number")
    Address toEntity(Location createAddressDto);

    @Mapping(target = "street.name", source = "street")
    @Mapping(target = "street.number", source = "number")
    AddressDto toDto(Address address);
}
