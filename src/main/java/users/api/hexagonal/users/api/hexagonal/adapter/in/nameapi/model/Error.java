package users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Error {

    @JsonProperty("error")
    private String errorMessage;
}
