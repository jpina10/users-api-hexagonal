package users.api.hexagonal.users.api.hexagonal.adapter.in.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;
import users.api.hexagonal.users.api.hexagonal.application.port.in.GetUserUseCase;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class GetUserController {

    private final GetUserUseCase getUserUseCase;

    @Operation(summary = "Retrieves a User given a username")
    @GetMapping(value = "/{username}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The User has been returned", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404", description = "The User has not been found", content = @Content)})
    User getUser(@PathVariable String username) {
        return getUserUseCase.getUserByUsername(username);
    }
}
