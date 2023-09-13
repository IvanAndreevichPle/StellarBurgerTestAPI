package api.user;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserLogin {
    private String email;
    private String password;

    @Step("Получение Email и пароля от созданого пользователя")
    public static UserLogin from(User user) {
        return new UserLogin(user.getEmail(), user.getPassword());
    }

    @Step("Создание собственного Email и пароля для логина")
    public static UserLogin create(String email, String password) {
        return new UserLogin(email, password);
    }
}