package com.ziofront.challenge;

import com.ziofront.challenge.service.MemberService;
import com.ziofront.challenge.vo.Member;
import com.ziofront.challenge.vo.MemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {


    private MemberService memberService;

    @Autowired
    public DataLoader(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        memberService.saveMember(Member.builder().name("라이언").loginId("test1").loginPassword("1024").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        memberService.saveMember(Member.builder().name("무지").loginId("test2").loginPassword("2048").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        memberService.saveMember(Member.builder().name("네오").loginId("test3").loginPassword("4096").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        memberService.saveMember(Member.builder().name("관리자").loginId("admin").loginPassword("8949").roles(Arrays.asList(MemberRole.builder().roleName("ADMIN").build())).build());
    }
}
