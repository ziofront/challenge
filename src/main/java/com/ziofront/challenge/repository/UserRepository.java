package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByLoginId(String loginId);
}
