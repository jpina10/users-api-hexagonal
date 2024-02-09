package users.api.hexagonal.users.api.hexagonal.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import users.api.hexagonal.users.api.hexagonal.application.exception.ResourceAlreadyExistsException;
import users.api.hexagonal.users.api.hexagonal.application.port.in.CreateRandomUserUseCase;
import users.api.hexagonal.users.api.hexagonal.application.port.out.CreateRandomUserPort;
import users.api.hexagonal.users.api.hexagonal.application.port.out.GetRandomUserPort;
import users.api.hexagonal.users.api.hexagonal.application.port.out.LoadUserPort;

@RequiredArgsConstructor
@Slf4j
public class CreateRandomUserService implements CreateRandomUserUseCase {

    private final GetRandomUserPort getRandomUserPort;
    private final CreateRandomUserPort createRandomUserPort;
    private final LoadUserPort loadUserPort;

    @Override
    public String createRandomUser() {
        var user = getRandomUserPort.getRandomUser();
        String username = user.getUsername();

        existsUser(username);

        createRandomUserPort.createRandomUser(user);
        return username;
    }

    private void existsUser(String username) {
        loadUserPort.findByUsername(username).ifPresent(user -> {
            throw new ResourceAlreadyExistsException("The user with username " + username + " already exists.");
        });
    }
}
