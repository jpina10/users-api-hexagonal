package users.api.hexagonal.users.api.hexagonal.application.port.out;

import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

public interface CreateRandomUserPort {
    void createRandomUser(User user);
}
