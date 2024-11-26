package com.pasifcode.blogapp.dto;

import com.pasifcode.blogapp.model.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;

    public AuthorDto() {
    }

    public AuthorDto(User user) {
        id = user.getId();
        username = user.getUsername();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


}
