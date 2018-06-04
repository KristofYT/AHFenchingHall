package com.aihui.fenchinghall.service;

import com.aihui.fenchinghall.model.Age;
import com.aihui.fenchinghall.model.Notice;

import java.util.List;

public interface NoticeService {

    public Notice findNoticeById(int id);

    public void updateNotice(Notice notice);

    public void saveNotice(Notice notice);

}
