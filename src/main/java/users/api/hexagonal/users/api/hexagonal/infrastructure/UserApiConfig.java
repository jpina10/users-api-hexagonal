package users.api.hexagonal.users.api.hexagonal.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import users.api.hexagonal.users.api.hexagonal.application.port.in.CreateRandomUserUseCase;
import users.api.hexagonal.users.api.hexagonal.application.port.in.GetUserUseCase;
import users.api.hexagonal.users.api.hexagonal.application.port.out.CreateRandomUserPort;
import users.api.hexagonal.users.api.hexagonal.application.port.out.GetRandomUserPort;
import users.api.hexagonal.users.api.hexagonal.application.port.out.LoadUserPort;
import users.api.hexagonal.users.api.hexagonal.application.service.CreateRandomUserService;
import users.api.hexagonal.users.api.hexagonal.application.service.GetUserService;

@Configuration
@RequiredArgsConstructor
public class UserApiConfig {

    private final GetRandomUserPort getRandomUserPort;
    private final CreateRandomUserPort createRandomUserPort;
    private final LoadUserPort loadUserPort;

    @Bean
    public GetUserUseCase getUserUseCase() {
        return new GetUserService(loadUserPort);
    }

    @Bean
    public CreateRandomUserUseCase createRandomUserUseCase() {
        return new CreateRandomUserService(getRandomUserPort, createRandomUserPort, loadUserPort);
    }
}
