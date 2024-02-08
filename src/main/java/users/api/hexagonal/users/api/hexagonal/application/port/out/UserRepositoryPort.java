package users.api.hexagonal.users.api.hexagonal.application.port.out;

import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

import java.util.Optional;

//all operations from userService in the layer arch
public interface UserRepositoryPort {
    Optional<User> findByUsername(String username);
}
