package users.api.hexagonal.users.api.hexagonal.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import users.api.hexagonal.users.api.hexagonal.application.exception.ResourceNotFoundException;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;
import users.api.hexagonal.users.api.hexagonal.application.port.out.LoadUserPort;
import users.api.hexagonal.users.api.hexagonal.factory.user.UserTestFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserServiceTest {

    private static final String USERNAME = "username";

    private final UserTestFactory userTestFactory = new UserTestFactory();

    @Mock
    private LoadUserPort loadUserPort;

    @InjectMocks
    private GetUserService getUserService;

    @Test
    void getUserByUsernameWithExistingUsername_ShouldReturnUser() {
        User user = userTestFactory.getUser();

        Optional<User> userEntityOptional = Optional.of(user);
        when(loadUserPort.findByUsername(user.getUsername())).thenReturn(userEntityOptional);

        getUserService.getUserByUsername(USERNAME);

        verify(loadUserPort).findByUsername(USERNAME);
    }

    @Test
    void getUserByUsernameWithNonExistingUsername_ShouldThrowException() {
        when(loadUserPort.findByUsername(any(String.class))).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> getUserService.getUserByUsername(USERNAME));

        verify(loadUserPort).findByUsername(USERNAME);
    }
}