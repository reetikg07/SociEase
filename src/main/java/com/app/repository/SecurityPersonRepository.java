package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.SecurityPerson;


public interface SecurityPersonRepository  extends JpaRepository<SecurityPerson, Integer> {

}
