package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.ServiceRequestDTO;

public interface ServiceRequestService {
    
    ServiceRequestDTO createServiceRequest(ServiceRequestDTO serviceRequestDTO);
    
    Optional<ServiceRequestDTO> getServiceRequestById(int id);
    
    List<ServiceRequestDTO> getAllServiceRequests();
    
    ServiceRequestDTO updateServiceRequest(int id, ServiceRequestDTO serviceRequestDTO);
    
    void deleteServiceRequest(int id);
}