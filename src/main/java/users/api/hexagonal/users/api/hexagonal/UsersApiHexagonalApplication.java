package users.api.hexagonal.users.api.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsersApiHexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApiHexagonalApplication.class, args);
    }

}
