package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ServiceRequestDTO;
import com.app.service.ServiceRequestService;

@RestController
@RequestMapping("/api/servicerequests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @PostMapping
    public ResponseEntity<ServiceRequestDTO> createServiceRequest(@RequestBody ServiceRequestDTO serviceRequestDTO) {
        ServiceRequestDTO createdRequest = serviceRequestService.createServiceRequest(serviceRequestDTO);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequestDTO> getServiceRequestById(@PathVariable int id) {
        return serviceRequestService.getServiceRequestById(id)
                .map(request -> new ResponseEntity<>(request, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequestDTO>> getAllServiceRequests() {
        List<ServiceRequestDTO> allRequests = serviceRequestService.getAllServiceRequests();
        return new ResponseEntity<>(allRequests, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequestDTO> updateServiceRequest(@PathVariable int id, @RequestBody ServiceRequestDTO serviceRequestDTO) {
        ServiceRequestDTO updatedRequest = serviceRequestService.updateServiceRequest(id, serviceRequestDTO);
        return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRequest(@PathVariable int id) {
        serviceRequestService.deleteServiceRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}