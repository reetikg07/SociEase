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

import com.app.dto.ServicePersonDTO;
import com.app.service.ServicePersonService;



@RestController

@RequestMapping("/servicepersons")

public class ServicePersonController {



  private final ServicePersonService servicePersonService;



  @Autowired

  public ServicePersonController(ServicePersonService servicePersonService) {

    this.servicePersonService = servicePersonService;

  }



  // Create operation

  @PostMapping

  public ResponseEntity<ServicePersonDTO> createServicePerson(@RequestBody ServicePersonDTO servicePersonDTO) {

    ServicePersonDTO createdServicePersonDTO = servicePersonService.createServicePerson(servicePersonDTO);

    return new ResponseEntity<>(createdServicePersonDTO, HttpStatus.CREATED);

  }



  // Read operations

  @GetMapping

  public ResponseEntity<List<ServicePersonDTO>> getAllServicePersons() {

    List<ServicePersonDTO> servicePersonDTOs = servicePersonService.getAllServicePersons();

    return new ResponseEntity<>(servicePersonDTOs, HttpStatus.OK);

  }



  @GetMapping("/{id}")

  public ResponseEntity<ServicePersonDTO> getServicePersonById(@PathVariable int id) {

    ServicePersonDTO servicePersonDTO = servicePersonService.getServicePersonById(id);

    if (servicePersonDTO != null) {

      return new ResponseEntity<>(servicePersonDTO, HttpStatus.OK);

    } else {

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

  }



  // Update operation

  @PutMapping("/{id}")

  public ResponseEntity<ServicePersonDTO> updateServicePerson(@PathVariable int id, @RequestBody ServicePersonDTO servicePersonDTO) {

    ServicePersonDTO updatedServicePersonDTO = servicePersonService.updateServicePerson(id, servicePersonDTO);

    if (updatedServicePersonDTO != null) {

      return new ResponseEntity<>(updatedServicePersonDTO, HttpStatus.OK);

    } else {

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

  }



  // Delete operation

  @DeleteMapping("/{id}")

  public ResponseEntity<Void> deleteServicePerson(@PathVariable int id) {

    servicePersonService.deleteServicePerson(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

}