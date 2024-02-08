package users.api.hexagonal.users.api.hexagonal.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import users.api.hexagonal.users.api.hexagonal.application.exception.ResourceAlreadyExistsException;
import users.api.hexagonal.users.api.hexagonal.application.port.in.CreateRandomUserUseCase;
import users.api.hexagonal.users.api.hexagonal.application.port.out.UserRepositoryPort;

@RequiredArgsConstructor
@Slf4j
public class CreateRandomUserService implements CreateRandomUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public String createRandomUser() {
        return userRepositoryPort.createRandomUser();
    }

    private void existsUser(String username) {
        userRepositoryPort.findByUsername(username).ifPresent(user1 -> {
            throw new ResourceAlreadyExistsException("The user with username " + username + " already exists.");
        });
    }
}
