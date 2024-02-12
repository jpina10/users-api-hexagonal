package users.api.hexagonal.users.api.hexagonal.application.model.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import users.api.hexagonal.users.api.hexagonal.application.model.user.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;

    private String name;

    private List<User> users;

    private void addUser(User user) {
        this.users.add(user);
        user.getRoles().add(this);
    }

    private void removeUser(User user) {
        this.users.remove(user);
        user.getRoles().remove(this);
    }
}
