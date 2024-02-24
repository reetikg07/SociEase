package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ServiceRequestDTO;
import com.app.entities.ServiceRequest;
import com.app.repository.ServiceRequestRepository;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceRequestDTO createServiceRequest(ServiceRequestDTO serviceRequestDTO) {
        ServiceRequest serviceRequest = modelMapper.map(serviceRequestDTO, ServiceRequest.class);
        ServiceRequest savedRequest = serviceRequestRepository.save(serviceRequest);
        return modelMapper.map(savedRequest, ServiceRequestDTO.class);
    }

    @Override
    public Optional<ServiceRequestDTO> getServiceRequestById(int id) {
        Optional<ServiceRequest> serviceRequestOptional = serviceRequestRepository.findById(id);
        return serviceRequestOptional.map(serviceRequest -> modelMapper.map(serviceRequest, ServiceRequestDTO.class));
    }

    @Override
    public List<ServiceRequestDTO> getAllServiceRequests() {
        List<ServiceRequest> serviceRequests = serviceRequestRepository.findAll();
        return serviceRequests.stream()
                .map(serviceRequest -> modelMapper.map(serviceRequest, ServiceRequestDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServiceRequestDTO updateServiceRequest(int id, ServiceRequestDTO serviceRequestDTO) {
        ServiceRequest existingRequest = serviceRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service Request not found with id: " + id));
        
        // Update existing request with new data
        existingRequest.setStatus(serviceRequestDTO.getStatus());
        existingRequest.setDateRequested(serviceRequestDTO.getDateRequested());
        existingRequest.setDescription(serviceRequestDTO.getDescription());

        ServiceRequest updatedRequest = serviceRequestRepository.save(existingRequest);
        return modelMapper.map(updatedRequest, ServiceRequestDTO.class);
    }

    @Override
    public void deleteServiceRequest(int id) {
        serviceRequestRepository.deleteById(id);
    }
}