package com.app.service;

import java.util.List;

import com.app.dto.SecurityPersonDTO;

public interface SecurityPersonService {
	
	 SecurityPersonDTO createSecurityPerson(SecurityPersonDTO securityPersonDTO);

	  List<SecurityPersonDTO> getAllSecurityPersons();

	  SecurityPersonDTO getSecurityPersonById(int id);

	  SecurityPersonDTO updateSecurityPerson(int id, SecurityPersonDTO updatedSecurityPersonDTO);

	  void deleteSecurityPerson(int id);

}
