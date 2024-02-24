package com.app.dto;

import java.time.LocalDate;

public class ServiceRequestDTO {
    private int id;
    private int flatOwnerId;
    private String status;
    private LocalDate dateRequested;
    private String description;

    // Constructors
    public ServiceRequestDTO() {}

    public ServiceRequestDTO(int id, int flatOwnerId, String status, LocalDate dateRequested, String description) {
        this.id = id;
        this.flatOwnerId = flatOwnerId;
        this.status = status;
        this.dateRequested = dateRequested;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlatOwnerId() {
        return flatOwnerId;
    }

    public void setFlatOwnerId(int flatOwnerId) {
        this.flatOwnerId = flatOwnerId;
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
