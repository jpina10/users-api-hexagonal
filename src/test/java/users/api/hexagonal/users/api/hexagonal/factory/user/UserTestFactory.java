package users.api.hexagonal.users.api.hexagonal.factory.user;

import users.api.hexagonal.users.api.hexagonal.application.model.address.Address;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

import java.time.LocalDateTime;
import java.util.List;

public class UserTestFactory {

    public User getUser() {
        return User.builder()
                .id(1L)
                .username("username")
                .password("password")
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .isEnabled(false)
                .email("email")
                .firstName("firstName")
                .lastName("lastName")
                .phoneNumber("phoneNumber")
                .addresses(List.of(getAddress()))
                .mainAddressId(getAddress().getId())
                .build();
    }

    private Address getAddress() {
        return Address.builder()
                .id(1L)
                .street("street")
                .number("number")
                .city("city")
                .country("country")
                .postCode("postCode")
                .build();
    }
}