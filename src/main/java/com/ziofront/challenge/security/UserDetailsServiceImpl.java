package com.ziofront.challenge.security;

import com.ziofront.challenge.repository.MemberRepository;
import com.ziofront.challenge.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member member = memberRepository.findByLoginId(loginId);
        return new UserDetailsImpl(member.getLoginId(), member.getLoginPassword(), "BASIC");

    }
}



