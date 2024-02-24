package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name = "visitors")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String contact;
    
    @Column(name = "enrollment_status", nullable = false)
    private String enrollmentStatus;
    
    @ManyToOne(cascade = CascadeType.ALL) // Cascade option is set here
    @JoinColumn(name = "securityperson_id", nullable = false)
    private SecurityPerson securityPerson;
    
    
    @ManyToOne(cascade = CascadeType.ALL) // Cascade option is set here
    @JoinColumn(name = "flatowner_id", nullable = false)
    private FlatOwner flatOwner;

	

    // Constructors, getters, setters
    
    public Visitor() {
		super();
	}

    
    


	public Visitor(int id, String name, String contact, String enrollmentStatus, SecurityPerson securityPerson,
			FlatOwner flatOwner) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.enrollmentStatus = enrollmentStatus;
		this.securityPerson = securityPerson;
		this.flatOwner = flatOwner;
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



	public SecurityPerson getSecurityPerson() {
		return securityPerson;
	}



	public void setSecurityPerson(SecurityPerson securityPerson) {
		this.securityPerson = securityPerson;
	}



	public FlatOwner getFlatOwner() {
		return flatOwner;
	}



	public void setFlatOwner(FlatOwner flatOwner) {
		this.flatOwner = flatOwner;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", contact=" + contact + ", enrollmentStatus="
				+ enrollmentStatus + ", securityPerson=" + securityPerson + ", flatOwner=" + flatOwner + "]";
	}
	
	
    
}
