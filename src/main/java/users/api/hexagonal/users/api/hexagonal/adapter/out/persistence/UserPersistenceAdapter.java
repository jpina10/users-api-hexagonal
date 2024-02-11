package users.api.hexagonal.users.api.hexagonal.adapter.out.persistence;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.RandomUserApiClient;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.dto.RandomUserApiResponse;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.mapper.RandomUserMapper;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.model.Result;
import users.api.hexagonal.users.api.hexagonal.adapter.out.persistence.entity.UserEntity;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.exception.ThirdPartyException;
import users.api.hexagonal.users.api.hexagonal.adapter.out.persistence.repository.UserJpaRepository;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;
import users.api.hexagonal.users.api.hexagonal.application.port.out.CreateRandomUserPort;
import users.api.hexagonal.users.api.hexagonal.application.port.out.GetRandomUserPort;
import users.api.hexagonal.users.api.hexagonal.application.port.out.LoadUserPort;
import users.api.hexagonal.users.api.hexagonal.common.mapper.UserMapper;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserPersistenceAdapter implements LoadUserPort, CreateRandomUserPort, GetRandomUserPort {

    private final RandomUserApiClient randomUserApiClient;
    private final UserJpaRepository userJpaRepository;

    private final UserMapper userMapper;
    private final RandomUserMapper randomUserMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        return userJpaRepository.findUserByUsername(username).map(userMapper::toModel);
    }

    @Override
    public User getRandomUser() {
        Result result = callRandomUserApi();
        UserEntity entity = randomUserMapper.toEntity(result);

        return userMapper.toModel(entity);
    }

    @Override
    @Transactional
    public void createRandomUser(User user) {
        UserEntity entity = userMapper.toEntity(user);

        userJpaRepository.save(entity);
    }

    private Result callRandomUserApi() {
        log.info("calling random user API...");

        var response = randomUserApiClient.getUserData();
        var hasError = hasError(response);

        /*
         * the random user api doesn't send an exception when down but send a JSON with an error field, this is why a try-catch wasn't used
         * https://randomuser.me/documentation#errors
         * */
        if (hasError) {
            String errorMessage = response.getError().getErrorMessage();
            log.error(errorMessage);

            throw new ThirdPartyException(errorMessage);
        }

        return response.getResults().get(0);
    }

    private boolean hasError(RandomUserApiResponse response) {
        return response.getError() != null;
    }
}
