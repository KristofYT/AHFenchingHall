package com.aihui.fenchinghall.repository;

import com.aihui.fenchinghall.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("noticeRepository")
public interface NoticeRepository extends JpaRepository<Notice,Integer> {





}
