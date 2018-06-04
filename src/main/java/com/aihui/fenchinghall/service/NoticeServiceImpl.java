package com.aihui.fenchinghall.service;


import com.aihui.fenchinghall.model.Notice;
import com.aihui.fenchinghall.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public Notice findNoticeById(int id) {
        return noticeRepository.findOne(Integer.valueOf(id));
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public void saveNotice(Notice notice) {
        noticeRepository.save(notice);
    }

}
