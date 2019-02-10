package com.ziofront.challenge.security;

import com.ziofront.challenge.vo.Member;
import com.ziofront.challenge.vo.MemberRole;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;


public class UserDetailsImpl extends User {

    private static final String ROLE_PREFIX = "ROLE_";

    @Getter
    private Member member;

    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
        return list;
    }

    public UserDetailsImpl(Member member) {
        super(member.getLoginId(), member.getLoginPassword(), makeGrantedAuthority(member.getRoles()));
        this.member = member;
    }

}