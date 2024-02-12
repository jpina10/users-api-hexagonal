package users.api.hexagonal.users.api.hexagonal.adapter.in.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "Location")
public class AddressDto {
    private StreetDto street;

    @Schema(description = "city of the user", example = "Wildberg")
    private String city;

    @Schema(description = "country of the user", example = "Switzerland")
    private String country;

    @Schema(description = "postal code of the user", example = "9717")
    private String postCode;
}
