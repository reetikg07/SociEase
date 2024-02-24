package com.app.dto;

public class FlatOwnerDTO {
    private int id;
    private String name;
    private String contact;
    private String flatNumber;

    // Constructors, getters, setters

    public FlatOwnerDTO() {
    }

    public FlatOwnerDTO(int id, String name, String contact, String flatNumber) {
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