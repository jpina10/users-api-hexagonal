package users.api.hexagonal.users.api.hexagonal.application.model.address;

import lombok.*;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private Long id;

    private String street;
    private String number;
    private String city;
    private String country;

    private String postCode;

    private User user;
}
