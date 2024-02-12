package users.api.hexagonal.users.api.hexagonal.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import users.api.hexagonal.users.api.hexagonal.application.exception.ResourceNotFoundException;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;
import users.api.hexagonal.users.api.hexagonal.application.port.in.GetUserUseCase;
import users.api.hexagonal.users.api.hexagonal.application.port.out.LoadUserPort;

@RequiredArgsConstructor
@Slf4j
public class GetUserService implements GetUserUseCase {

    private final LoadUserPort loadUserPort;

    @Override
    public User getUserByUsername(String username) {
        log.info("Retrieving user with username: {}", username);
        return loadUserPort.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("user with username " + username + " does not exist."));
    }
}
