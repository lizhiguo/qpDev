package com.qp.biz.emp.service;

import com.qp.biz.emp.entity.Person;
import com.qp.biz.emp.repository.PersonRepository;
import com.qp.common.event.annotation.HibernateEventListener;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PreInsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 78772
 */
@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void save(Person person){
        personRepository.save(person);
    }

    @HibernateEventListener
    public void handlePreInsert(Person entity, PreInsertEvent event){
//        System.out.println();
        System.out.println("------Person---handlePreInsert---------");
//        log.debug("entity=={}", JSONUtil.toJsonPrettyStr(entity));
    }
}
