package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findByLoginId(String loginId);
}
