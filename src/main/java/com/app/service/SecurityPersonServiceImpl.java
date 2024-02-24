package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.SecurityPersonDTO;
import com.app.entities.SecurityPerson;
import com.app.repository.SecurityPersonRepository;

@Service
public class SecurityPersonServiceImpl implements SecurityPersonService {

  private final SecurityPersonRepository securityPersonRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public SecurityPersonServiceImpl(SecurityPersonRepository securityPersonRepository, ModelMapper modelMapper) {
    this.securityPersonRepository = securityPersonRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public SecurityPersonDTO createSecurityPerson(SecurityPersonDTO securityPersonDTO) {
    SecurityPerson securityPerson = modelMapper.map(securityPersonDTO, SecurityPerson.class);
    SecurityPerson savedSecurityPerson = securityPersonRepository.save(securityPerson);
    return modelMapper.map(savedSecurityPerson, SecurityPersonDTO.class);
  }

  @Override
  public List<SecurityPersonDTO> getAllSecurityPersons() {
    List<SecurityPerson> securityPersons = securityPersonRepository.findAll();
    return securityPersons.stream()
        .map(securityPerson -> modelMapper.map(securityPerson, SecurityPersonDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public SecurityPersonDTO getSecurityPersonById(int id) {
    Optional<SecurityPerson> securityPerson = securityPersonRepository.findById(id);
    return securityPerson.map(value -> modelMapper.map(value, SecurityPersonDTO.class)).orElse(null);
  }

  @Override
  public SecurityPersonDTO updateSecurityPerson(int id, SecurityPersonDTO updatedSecurityPersonDTO) {
    Optional<SecurityPerson> optionalSecurityPerson = securityPersonRepository.findById(id);
    if (optionalSecurityPerson.isPresent()) {
      SecurityPerson securityPerson = modelMapper.map(updatedSecurityPersonDTO, SecurityPerson.class);
      securityPerson.setId(id);
      SecurityPerson updatedSecurityPerson = securityPersonRepository.save(securityPerson);
      return modelMapper.map(updatedSecurityPerson, SecurityPersonDTO.class);
    } else {
      return null; // Or throw an exception
    }
  }

  @Override
  public void deleteSecurityPerson(int id) {
    securityPersonRepository.deleteById(id);
  }
}