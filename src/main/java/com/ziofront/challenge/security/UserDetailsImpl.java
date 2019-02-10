package com.ziofront.challenge.security;

import com.ziofront.challenge.vo.Member;
import com.ziofront.challenge.vo.MemberRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl extends User {

    private static final String ROLE_PREFIX = "ROLE_";

//    public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//    }
//
//    public UserDetailsImpl(String username, String password, boolean enabled, boolean accountNonExpired,
//                           boolean credentialsNonExpired, boolean accountNonLocked,
//                           Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//    }
//
    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
        return list;
    }
//
//    public UserDetailsImpl(String email, String password, String s) {
//        super(email, password, AuthorityUtils.createAuthorityList(s));
//    }

    public UserDetailsImpl(Member member) {
        super(member.getLoginId(), member.getLoginPassword(), makeGrantedAuthority(member.getRoles()));
    }
}