package com.qp.biz.emp.repository;

import com.qp.biz.emp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
