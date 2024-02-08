package users.api.hexagonal.users.api.hexagonal.adapter.out.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;
import users.api.hexagonal.users.api.hexagonal.application.port.out.UserRepositoryPort;
import users.api.hexagonal.users.api.hexagonal.common.mapper.UserMapper;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return userJpaRepository.findUserByUsername(username).map(userMapper::toModel);
    }

}
