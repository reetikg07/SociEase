package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.FlatOwner;

public interface FlatOwnerService {
	
	 	FlatOwner createFlatOwner(FlatOwner flatOwner);
	    
	    Optional<FlatOwner> getFlatOwnerById(int id);
	    
	    List<FlatOwner> getAllFlatOwners();
	    
	    FlatOwner updateFlatOwner(int id, FlatOwner flatOwner);
	    
	    void deleteFlatOwner(int id);
	}


