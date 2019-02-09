package com.ziofront.challenge.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserDetailsImpl extends User {

    /* security 에서 제공하는 Member 객체를 상속받아야함 난 이부분에서 진짜 많이 헤맴 ... */


    public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserDetailsImpl(String username, String password, boolean enabled, boolean accountNonExpired,
                       boolean credentialsNonExpired, boolean accountNonLocked,
                       Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /* 사실 여기선 이거밖에 안씀. 위에 두개는 어떤거 하는지 모르겠는데 좀더 연구한 후에... */
    public UserDetailsImpl(String email, String password, String s) {
        super(email, password, AuthorityUtils.createAuthorityList(s));
    }
}