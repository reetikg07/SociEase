package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ServicePersonDTO;
import com.app.entities.ServicePerson;
import com.app.repository.ServicePersonRepository;

@Service

public class ServicePersonServiceImpl implements ServicePersonService {



  private final ServicePersonRepository servicePersonRepository;

  private final ModelMapper modelMapper;



  @Autowired

  public ServicePersonServiceImpl(ServicePersonRepository servicePersonRepository, ModelMapper modelMapper) {

    this.servicePersonRepository = servicePersonRepository;

    this.modelMapper = modelMapper;

  }



  @Override

  public ServicePersonDTO createServicePerson(ServicePersonDTO servicePersonDTO) {

    ServicePerson servicePerson = modelMapper.map(servicePersonDTO, ServicePerson.class);

    ServicePerson savedServicePerson = servicePersonRepository.save(servicePerson);

    return modelMapper.map(savedServicePerson, ServicePersonDTO.class);

  }



  @Override

  public List<ServicePersonDTO> getAllServicePersons() {

    List<ServicePerson> servicePersons = servicePersonRepository.findAll();

    return servicePersons.stream()

        .map(servicePerson -> modelMapper.map(servicePerson, ServicePersonDTO.class))

        .collect(Collectors.toList());

  }



  @Override

  public ServicePersonDTO getServicePersonById(int id) {

    Optional<ServicePerson> servicePerson = servicePersonRepository.findById(id);

    return servicePerson.map(value -> modelMapper.map(value, ServicePersonDTO.class)).orElse(null);

  }



  @Override

  public ServicePersonDTO updateServicePerson(int id, ServicePersonDTO updatedServicePersonDTO) {

    Optional<ServicePerson> optionalServicePerson = servicePersonRepository.findById(id);

    if (optionalServicePerson.isPresent()) {

      ServicePerson servicePerson = modelMapper.map(updatedServicePersonDTO, ServicePerson.class);

      servicePerson.setId(id);

      ServicePerson updatedServicePerson = servicePersonRepository.save(servicePerson);

      return modelMapper.map(updatedServicePerson, ServicePersonDTO.class);

    } else {

      return null; // Or throw an exception

    }

  }



  @Override

  public void deleteServicePerson(int id) {

    servicePersonRepository.deleteById(id);

  }

}