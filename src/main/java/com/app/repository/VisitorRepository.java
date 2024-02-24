package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

}
