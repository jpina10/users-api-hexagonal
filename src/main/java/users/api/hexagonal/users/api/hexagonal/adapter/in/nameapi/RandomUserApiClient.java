package users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import users.api.hexagonal.users.api.hexagonal.adapter.in.nameapi.dto.RandomUserApiResponse;

@FeignClient(name = "randomUserApiClient", url = "https://randomuser.me/api")
public interface RandomUserApiClient {

    @GetMapping
    RandomUserApiResponse getUserData();
}
