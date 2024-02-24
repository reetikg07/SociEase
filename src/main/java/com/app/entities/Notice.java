package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "notices")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String content;
    
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;
    
    @ManyToOne(cascade = CascadeType.ALL) // Cascade option is set here
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;


    // Constructors, getters, setters
    
	public Notice() {
		super();
	}


	public Notice(int id, String title, String content, LocalDate dateCreated, Admin admin) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.dateCreated = dateCreated;
		this.admin = admin;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	
    
    
}