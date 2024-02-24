package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.NoticeDTO;
import com.app.entities.Admin;
import com.app.entities.Notice;
import com.app.repository.AdminRepository;
import com.app.repository.NoticeRepository;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;
    @Autowired
	AdminRepository adminRepository;

    @Autowired
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }
    
    @Override
    public Notice createNotice(Notice notice) {
        // Fetch and attach the associated Admin entity
    	
        Admin admin = adminRepository.findById(notice.getAdmin().getId())
                .orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + notice.getAdmin().getId()));
        notice.setAdmin(admin);

        // Save the Notice entity
        return noticeRepository.save(notice);
    }

    @Override
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice getNoticeById(int id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notice not found with id: " + id));
    }

    @Override
    public Notice updateNotice(int id, Notice notice) {
        // Fetch the existing notice by id
        Notice existingNotice = noticeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notice not found with id: " + id));

        // Update the existing notice with new data
        existingNotice.setTitle(notice.getTitle());
        existingNotice.setContent(notice.getContent());

        // Save the updated notice
        return noticeRepository.save(existingNotice);
    }

    @Override
    public void deleteNotice(int id) {
        noticeRepository.deleteById(id);
    }
}