package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Admin;

public interface AdminService {
	
    Admin createAdmin(Admin admin);
    
    Optional<Admin> getAdminById(int id);
    
    List<Admin> getAllAdmins();
    
    Admin updateAdmin(int id, Admin admin);
    
    void deleteAdmin(int id);
}