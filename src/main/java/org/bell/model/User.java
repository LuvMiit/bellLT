package org.bell.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
//@NoArgsConstructor
public class User {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    private String date;

    public User(String login, String password) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.login = login;
        this.password = password;
        this.date = sdf.format(new Date());
    }

    @Override
    public String toString() {
        return "{"+
                "\"login\":\"" + login + "\"," +
                "\"password\":\"" + password + "\"," +
                "\"date\":\"" + date + "\"" +
                "}";
    }
}
