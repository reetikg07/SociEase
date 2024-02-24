package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Integer> {

}
