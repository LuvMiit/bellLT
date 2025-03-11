package org.bell.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostResponse {
    private String login;
    private String password;
    private String date;
}
