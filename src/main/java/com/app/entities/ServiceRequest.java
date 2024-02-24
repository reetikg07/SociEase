package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL) // Cascade option is set here
    @JoinColumn(name = "flatowner_id", nullable = false)
    private FlatOwner flatOwner;
    
    @Column(nullable = false)
    private String status;
    
    @Column(name = "date_requested", nullable = false)
    private LocalDate dateRequested;
    
    @Column(nullable = false)
    private String description;



    // Constructors, getters, setters
	public ServiceRequest() {
		super();
	}



	public ServiceRequest(int id, FlatOwner flatOwner, String status, LocalDate dateRequested, String description) {
		super();
		this.id = id;
		this.flatOwner = flatOwner;
		this.status = status;
		this.dateRequested = dateRequested;
		this.description = description;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public FlatOwner getFlatOwner() {
		return flatOwner;
	}



	public void setFlatOwner(FlatOwner flatOwner) {
		this.flatOwner = flatOwner;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public LocalDate getDateRequested() {
		return dateRequested;
	}



	public void setDateRequested(LocalDate dateRequested) {
		this.dateRequested = dateRequested;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}
	
	
    
}