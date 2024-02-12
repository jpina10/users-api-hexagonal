package users.api.hexagonal.users.api.hexagonal.adapter.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.dto.CreateUserResponse;
import users.api.hexagonal.users.api.hexagonal.application.port.in.CreateRandomUserUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "Users")
public class CreateRandomUserController {

    private final CreateRandomUserUseCase createRandomUserUseCase;

    @Operation(summary = "Creates a User calling a 3rd party API")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The User has been created"),
            @ApiResponse(responseCode = "503", description = "Random user API not available")
    })
    public ResponseEntity<CreateUserResponse> createRandomUser() {
        String username = createRandomUserUseCase.createRandomUser();

        return new ResponseEntity<>(new CreateUserResponse(username), HttpStatus.CREATED);
    }
}
