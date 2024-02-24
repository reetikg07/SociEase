package com.app.dto;

public class ServicePersonDTO {

	  private int id;

	  private String name;

	  private String contact;

	  private String email;

	  private String type;



	  // Constructors, getters, setters

	   

	  public ServicePersonDTO() {

	    // Default constructor

	  }



	  public ServicePersonDTO(int id, String name, String contact, String email, String type) {

	    this.id = id;

	    this.name = name;

	    this.contact = contact;

	    this.email = email;

	    this.type = type;

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



	  public String getType() {

	    return type;

	  }



	  public void setType(String type) {

	    this.type = type;

	  }

	}