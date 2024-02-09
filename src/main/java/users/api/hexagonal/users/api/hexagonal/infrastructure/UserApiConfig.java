package users.api.hexagonal.users.api.hexagonal.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import users.api.hexagonal.users.api.hexagonal.application.port.in.GetUserUseCase;
import users.api.hexagonal.users.api.hexagonal.application.port.out.UserRepositoryPort;
import users.api.hexagonal.users.api.hexagonal.application.service.GetUserService;

@Configuration
@RequiredArgsConstructor
public class UserApiConfig {

    private final UserRepositoryPort userRepositoryPort;

    @Bean
    public GetUserUseCase getUserUseCase() {
        return new GetUserService(userRepositoryPort);
    }

}
