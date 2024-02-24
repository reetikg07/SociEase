package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.NoticeDTO;
import com.app.entities.Notice;
import com.app.service.NoticeService;

@RestController
@RequestMapping("/notices")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        Notice createdNotice = noticeService.createNotice(notice);
        return new ResponseEntity<>(createdNotice, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable int id) {
        Notice notice = noticeService.getNoticeById(id);
        return new ResponseEntity<>(notice, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> updateNotice(@PathVariable int id, @RequestBody Notice notice) {
        Notice updatedNotice = noticeService.updateNotice(id, notice);
        return new ResponseEntity<>(updatedNotice, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable int id) {
        noticeService.deleteNotice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}