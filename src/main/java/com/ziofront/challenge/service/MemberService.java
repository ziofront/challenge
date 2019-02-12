package com.ziofront.challenge.service;

import com.ziofront.challenge.repository.MemberRepository;
import com.ziofront.challenge.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author jiho
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * @param member
     */
    public void saveMember(Member member) {

        member.setLoginPassword(new BCryptPasswordEncoder().encode(member.getLoginPassword()));
        memberRepository.save(member);

    }
}
