package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.Member;
import com.ziofront.challenge.vo.MemberRole;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMemberRepository {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test0_initMemberData() {

        List<Member> userList = new ArrayList<Member>();
        userList.add(Member.builder().name("라이언").loginId("test1").loginPassword("1024").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        userList.add(Member.builder().name("무지").loginId("test2").loginPassword("2048").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        userList.add(Member.builder().name("네오").loginId("test3").loginPassword("4096").roles(Arrays.asList(MemberRole.builder().roleName("BASIC").build())).build());
        userList.add(Member.builder().name("관리자").loginId("admin").loginPassword("8949").roles(Arrays.asList(MemberRole.builder().roleName("ADMIN").build())).build());

        memberRepository.saveAll(userList);
    }

    @Test
    public void test1_FindMemberByLoginId() {
        Member user = memberRepository.findByLoginId("test2");
        assertTrue(user != null);
    }

    @Test
    public void test2_FindMemberByLoginId() {
        Member user = memberRepository.findByLoginId("admin");
        assertTrue(user != null);
    }

    @Test
    public void test3_FindMemberByLoginId() {
        Member user = memberRepository.findByLoginId("hello");
        assertTrue(user == null);
    }
}
