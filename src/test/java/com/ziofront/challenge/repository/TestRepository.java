package com.ziofront.challenge.repository;

import com.ziofront.challenge.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepository {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void initData() {

        List<User> userList = new ArrayList<User>();
        userList.add(User.builder().name("라이언").loginId("test1").loginPassword("1234").build());
        userList.add(User.builder().name("무지").loginId("test2").loginPassword("4567").build());
        userList.add(User.builder().name("네오").loginId("test3").loginPassword("8901").build());

        userRepository.saveAll(userList);


    }

    @Test
    public void test1FindUserByLoginId() {
        User user = userRepository.findByLoginId("test2");
        assertTrue(user != null);
    }
}
