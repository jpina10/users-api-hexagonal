package users.api.hexagonal.users.api.hexagonal.application.port.out;

import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

import java.util.Optional;

public interface LoadUserPort {
    Optional<User> findByUsername(String username);
}
