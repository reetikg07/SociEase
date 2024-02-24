package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Admin;
import com.app.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	  @Autowired
     AdminRepository adminRepository;

 

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin updateAdmin(int id, Admin admin) {
        admin.setId(id); // Set ID from path variable
        return adminRepository.save(admin);
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }

}
