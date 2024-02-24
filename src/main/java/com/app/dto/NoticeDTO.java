package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Admin;

public class NoticeDTO {

	  private int id;

	  private String title;

	  private String content;

	  private LocalDate dateCreated;
	  
	  private Admin admin;



	  // Constructors, getters, setters



	  public NoticeDTO() {

	    // Default constructor

	  }



	  public NoticeDTO(int id, String title, String content, LocalDate dateCreated,Admin admin) {

	    this.id = id;

	    this.title = title;

	    this.content = content;

	    this.dateCreated = dateCreated;
	    
	    this.admin=admin;

	  }



	  // Getters and setters



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