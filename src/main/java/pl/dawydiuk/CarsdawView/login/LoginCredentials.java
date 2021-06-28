package pl.dawydiuk.CarsdawView.login;

import lombok.Getter;

@Getter
public class LoginCredentials {
    private String username;
    private String password;

    public LoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}



