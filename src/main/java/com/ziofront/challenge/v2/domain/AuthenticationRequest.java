package com.ziofront.challenge.v2.domain;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}
