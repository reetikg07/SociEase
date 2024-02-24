package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Admin;
import com.app.entities.FlatOwner;


public interface AdminRepository  extends JpaRepository<Admin, Integer>{

}
