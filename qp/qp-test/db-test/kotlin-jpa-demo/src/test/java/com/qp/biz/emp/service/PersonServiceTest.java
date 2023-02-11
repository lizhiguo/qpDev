package com.qp.biz.emp.service;

import com.qp.biz.emp.entity.Person;
import com.qp.blog.User;
import com.qp.blog.UserRepository;
import com.qp.common.annotation.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void xx(){
        Person p = new Person();
        p.setName("king-lhl");
        p.setId(2L);
        personService.save(p);
    }
    @Test
    void kotlin_xx(){
        User u = new User();
        u.setFirstname("king");
        u.setLogin("uiui");
        u.setLastname("lhl");
        u.setDescription("hello");
        u.setId(299L);
        userRepository.save(u);
    }
}
