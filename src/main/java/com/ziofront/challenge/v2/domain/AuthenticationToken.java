package com.ziofront.challenge.v2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class AuthenticationToken {

    private String username;
    private Collection authorities;
    private String token;

}
