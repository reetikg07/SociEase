package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Visitor;

public interface VisitorService {
	
	 Visitor createVisitor(Visitor visitor);
	    
	    Optional<Visitor> getVisitorById(int id);
	    
	    List<Visitor> getAllVisitors();
	    
	    Visitor updateVisitor(int id, Visitor visitorDetails);
	    
	    void deleteVisitor(int id);

}
