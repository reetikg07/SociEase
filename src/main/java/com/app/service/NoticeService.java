package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.NoticeDTO;
import com.app.entities.Notice;

public interface NoticeService {
	 Notice createNotice(Notice notice);
	    List<Notice> getAllNotices();
	    Notice getNoticeById(int id);
	    Notice updateNotice(int id, Notice notice);
	    void deleteNotice(int id);
}

