package users.api.hexagonal.users.api.hexagonal.application.model.user;

import lombok.*;
import users.api.hexagonal.users.api.hexagonal.application.model.address.Address;
import users.api.hexagonal.users.api.hexagonal.application.model.role.Role;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;

    private String username;

    private String password;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private boolean isEnabled;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private List<Address> addresses;

    private Long mainAddressId;

    private List<Role> roles;
}
