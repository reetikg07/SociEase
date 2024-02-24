package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "security_persons")
public class SecurityPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String contact;
    
    @Column(nullable = false)
    private String email;



    // Constructors, getters, setters
	public SecurityPerson() {
		super();
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
	
	
    
}
