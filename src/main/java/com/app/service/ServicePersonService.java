package com.app.service;

import java.util.List;

import com.app.dto.ServicePersonDTO;

public interface ServicePersonService {

	   

	  ServicePersonDTO createServicePerson(ServicePersonDTO servicePersonDTO);

	   

	  List<ServicePersonDTO> getAllServicePersons();

	   

	  ServicePersonDTO getServicePersonById(int id);

	   

	  ServicePersonDTO updateServicePerson(int id, ServicePersonDTO updatedServicePersonDTO);

	   

	  void deleteServicePerson(int id);

	}