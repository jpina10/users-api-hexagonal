package users.api.hexagonal.users.api.hexagonal.application.port.in;

import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

public interface GetUserUseCase {
    User getUserByUsername(String username);
}
