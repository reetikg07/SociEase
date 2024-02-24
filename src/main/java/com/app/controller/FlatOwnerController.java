package com.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.app.dto.FlatOwnerDTO;
import com.app.entities.FlatOwner;
import com.app.service.FlatOwnerService;

@RestController
@RequestMapping("/flatowners")
public class FlatOwnerController {

    private final FlatOwnerService flatOwnerService;

    @Autowired
    public FlatOwnerController(FlatOwnerService flatOwnerService) {
        this.flatOwnerService = flatOwnerService;
    }

    @PostMapping
    public ResponseEntity<FlatOwnerDTO> createFlatOwner(@RequestBody FlatOwnerDTO flatOwnerDTO) {
        FlatOwner flatOwner = convertToEntity(flatOwnerDTO);
        FlatOwner createdFlatOwner = flatOwnerService.createFlatOwner(flatOwner);
        return new ResponseEntity<>(convertToDTO(createdFlatOwner), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlatOwnerDTO> getFlatOwnerById(@PathVariable int id) {
        Optional<FlatOwner> flatOwnerOptional = flatOwnerService.getFlatOwnerById(id);
        return flatOwnerOptional.map(flatOwner -> new ResponseEntity<>(convertToDTO(flatOwner), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<FlatOwnerDTO>> getAllFlatOwners() {
        List<FlatOwner> flatOwners = flatOwnerService.getAllFlatOwners();
        List<FlatOwnerDTO> flatOwnerDTOs = flatOwners.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(flatOwnerDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlatOwnerDTO> updateFlatOwner(@PathVariable int id, @RequestBody FlatOwnerDTO flatOwnerDTO) {
        FlatOwner flatOwner = convertToEntity(flatOwnerDTO);
        flatOwner.setId(id); // Set ID from path variable
        FlatOwner updatedFlatOwner = flatOwnerService.updateFlatOwner(id, flatOwner);
        return new ResponseEntity<>(convertToDTO(updatedFlatOwner), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlatOwner(@PathVariable int id) {
        flatOwnerService.deleteFlatOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private FlatOwnerDTO convertToDTO(FlatOwner flatOwner) {
        FlatOwnerDTO flatOwnerDTO = new FlatOwnerDTO();
        flatOwnerDTO.setId(flatOwner.getId());
        flatOwnerDTO.setName(flatOwner.getName());
        flatOwnerDTO.setContact(flatOwner.getContact());
        flatOwnerDTO.setFlatNumber(flatOwner.getFlatNumber());
        return flatOwnerDTO;
    }

    private FlatOwner convertToEntity(FlatOwnerDTO flatOwnerDTO) {
        FlatOwner flatOwner = new FlatOwner();
        flatOwner.setId(flatOwnerDTO.getId());
        flatOwner.setName(flatOwnerDTO.getName());
        flatOwner.setContact(flatOwnerDTO.getContact());
        flatOwner.setFlatNumber(flatOwnerDTO.getFlatNumber());
        return flatOwner;
    }
}