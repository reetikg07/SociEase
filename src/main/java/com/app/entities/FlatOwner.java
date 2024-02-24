package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "flat_owners")
public class FlatOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String contact;
    
    @Column(name = "flat_number", nullable = false)
    private String flatNumber;

    
    

    // Constructors, getters, setters

	public FlatOwner() {
		super();
	}




	public FlatOwner(int id, String name, String contact, String flatNumber) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.flatNumber = flatNumber;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getContact() {
		return contact;
	}




	public void setContact(String contact) {
		this.contact = contact;
	}




	public String getFlatNumber() {
		return flatNumber;
	}




	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	
	
    
}