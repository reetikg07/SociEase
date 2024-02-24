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

import com.app.dto.SecurityPersonDTO;
import com.app.service.SecurityPersonService;

@RestController
@RequestMapping("/securitypersons")
public class SecurityPersonController {

  private final SecurityPersonService securityPersonService;

  @Autowired
  public SecurityPersonController(SecurityPersonService securityPersonService) {
    this.securityPersonService = securityPersonService;
  }

  // Create operation
  @PostMapping
  public ResponseEntity<SecurityPersonDTO> createSecurityPerson(@RequestBody SecurityPersonDTO securityPersonDTO) {
    SecurityPersonDTO createdSecurityPersonDTO = securityPersonService.createSecurityPerson(securityPersonDTO);
    return new ResponseEntity<>(createdSecurityPersonDTO, HttpStatus.CREATED);
  }

  // Read operations
  @GetMapping
  public ResponseEntity<List<SecurityPersonDTO>> getAllSecurityPersons() {
    List<SecurityPersonDTO> securityPersonDTOs = securityPersonService.getAllSecurityPersons();
    return new ResponseEntity<>(securityPersonDTOs, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SecurityPersonDTO> getSecurityPersonById(@PathVariable int id) {
    SecurityPersonDTO securityPersonDTO = securityPersonService.getSecurityPersonById(id);
    if (securityPersonDTO != null) {
      return new ResponseEntity<>(securityPersonDTO, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Update operation
  @PutMapping("/{id}")
  public ResponseEntity<SecurityPersonDTO> updateSecurityPerson(@PathVariable int id, @RequestBody SecurityPersonDTO securityPersonDTO) {
    SecurityPersonDTO updatedSecurityPersonDTO = securityPersonService.updateSecurityPerson(id, securityPersonDTO);
    if (updatedSecurityPersonDTO != null) {
      return new ResponseEntity<>(updatedSecurityPersonDTO, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Delete operation
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSecurityPerson(@PathVariable int id) {
    securityPersonService.deleteSecurityPerson(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
