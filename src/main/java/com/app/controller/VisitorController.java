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

import com.app.dto.VisitorDTO;
import com.app.entities.Visitor;
import com.app.service.VisitorService;

@RestController
@RequestMapping("/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor) {
        Visitor createdVisitor = visitorService.createVisitor(visitor);
        return new ResponseEntity<>(createdVisitor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable int id) {
        Optional<Visitor> visitor = visitorService.getVisitorById(id);
        return visitor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        List<Visitor> visitors = visitorService.getAllVisitors();
        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable int id, @RequestBody Visitor visitorDetails) {
        Visitor updatedVisitor = visitorService.updateVisitor(id, visitorDetails);
        if (updatedVisitor != null) {
            return new ResponseEntity<>(updatedVisitor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable int id) {
        visitorService.deleteVisitor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}