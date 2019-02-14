package com.ziofront.challenge.security;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class AuthenticationToken {

    private String username;
    private Collection authorities;
    private String token;
}
