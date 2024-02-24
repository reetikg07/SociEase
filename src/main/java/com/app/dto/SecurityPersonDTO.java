package com.app.dto;

public class SecurityPersonDTO {
	  private int id;
	  private String name;
	  private String contact;
	  private String email;

	  // Constructors, getters, setters
	   
	  public SecurityPersonDTO() {
	    // Default constructor
	  }

	  public SecurityPersonDTO(int id, String name, String contact, String email) {
	    this.id = id;
	    this.name = name;
	    this.contact = contact;
	    this.email = email;
	  }

	  // Getters and setters

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
