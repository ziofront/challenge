package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jiho
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByLoginId(String loginId);
}
