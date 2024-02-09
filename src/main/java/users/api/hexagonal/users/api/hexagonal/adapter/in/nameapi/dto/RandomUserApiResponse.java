package users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.model.Error;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.model.Result;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomUserApiResponse {
    private List<Result> results;
    private Error error;
}
