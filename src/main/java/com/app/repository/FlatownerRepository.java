package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.FlatOwner;
import com.app.entities.Visitor;

public interface FlatownerRepository extends JpaRepository<FlatOwner, Integer> {

}
