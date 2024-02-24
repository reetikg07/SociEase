package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Visitor;
import com.app.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public Optional<Visitor> getVisitorById(int id) {
        return visitorRepository.findById(id);
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor updateVisitor(int id, Visitor visitorDetails) {
        if (!visitorRepository.existsById(id)) {
            // Visitor with given id not found
            return null;
        }
        visitorDetails.setId(id);
        return visitorRepository.save(visitorDetails);
    }

    @Override
    public void deleteVisitor(int id) {
        visitorRepository.deleteById(id);
    }
}