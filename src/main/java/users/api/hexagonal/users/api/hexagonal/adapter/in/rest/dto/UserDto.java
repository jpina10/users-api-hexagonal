package users.api.hexagonal.users.api.hexagonal.adapter.in.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "User")
public class UserDto {

    @Schema(description = "username of the user", example = "sadladybug779")
    private String username;

    @Schema(description = "email of the user", example = "miro.bernard@example.com")
    private String email;

    @Schema(description = "first name of the user", example = "Miro")
    private String firstName;

    @Schema(description = "last name of the user", example = "Bernard")
    private String lastName;

    @Schema(description = "phone number of the user", example = "079 046 97 17")
    private String phoneNumber;

    @Schema(description = "location of the user")
    private List<AddressDto> addresses;
}
