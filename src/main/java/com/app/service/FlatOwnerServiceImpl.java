package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.FlatOwner;
import com.app.repository.FlatownerRepository;

@Service
public class FlatOwnerServiceImpl implements FlatOwnerService {

	 @Autowired
	 FlatownerRepository flatOwnerRepository;


    @Override
    public FlatOwner createFlatOwner(FlatOwner flatOwner) {
        return flatOwnerRepository.save(flatOwner);
    }

    @Override
    public Optional<FlatOwner> getFlatOwnerById(int id) {
        return flatOwnerRepository.findById(id);
    }

    @Override
    public List<FlatOwner> getAllFlatOwners() {
        return flatOwnerRepository.findAll();
    }

    @Override
    public FlatOwner updateFlatOwner(int id, FlatOwner flatOwner) {
        flatOwner.setId(id); // Set ID from path variable
        return flatOwnerRepository.save(flatOwner);
    }

    @Override
    public void deleteFlatOwner(int id) {
        Optional<FlatOwner> flatOwnerOptional = flatOwnerRepository.findById(id);
        flatOwnerOptional.ifPresent(flatOwner -> {
            // Remove all associated visitors before deleting the flat owner
           // flatOwner.getVisitors().forEach(visitor -> visitor.setFlatOwner(null));
            flatOwnerRepository.deleteById(id);
        });
    }
}