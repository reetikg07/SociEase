package com.app.dto;

public class VisitorDTO {
    private int id;
    private String name;
    private String contact;
    private String enrollmentStatus;
    private int securityPersonId;
    private int flatOwnerId;

    // Constructors, getters, setters

    public VisitorDTO() {
    }

    public VisitorDTO(int id, String name, String contact, String enrollmentStatus, int securityPersonId, int flatOwnerId) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.enrollmentStatus = enrollmentStatus;
        this.securityPersonId = securityPersonId;
        this.flatOwnerId = flatOwnerId;
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

	public String getEnrollmentStatus() {
		return enrollmentStatus;
	}

	public void setEnrollmentStatus(String enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	public int getSecurityPersonId() {
		return securityPersonId;
	}

	public void setSecurityPersonId(int securityPersonId) {
		this.securityPersonId = securityPersonId;
	}

	public int getFlatOwnerId() {
		return flatOwnerId;
	}

	public void setFlatOwnerId(int flatOwnerId) {
		this.flatOwnerId = flatOwnerId;
	}

	@Override
	public String toString() {
		return "VisitorDTO [id=" + id + ", name=" + name + ", contact=" + contact + ", enrollmentStatus="
				+ enrollmentStatus + ", securityPersonId=" + securityPersonId + ", flatOwnerId=" + flatOwnerId + "]";
	}

    // Getters and setters
    // Omitted for brevity
    
    
}
