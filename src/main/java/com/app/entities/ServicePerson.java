package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "service_persons")
public class ServicePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String contact;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String type;

	

    // Constructors, getters, setters
    public ServicePerson() {
		super();
	}



	public ServicePerson(int id, String name, String contact, String email, String type) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.type = type;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
    
    
    
}