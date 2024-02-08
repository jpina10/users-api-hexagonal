package users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Error {

    @JsonProperty("error")
    private String errorMessage;
}
