package com.aihui.fenchinghall.repository;

import com.aihui.fenchinghall.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("scheduleRepository")
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

    @Query(value="SELECT u.`*` FROM SCHEDULE AS u WHERE u.user_id=?1",nativeQuery = true)
    List<Schedule> findScheduleByUserId(int id);

    @Query(value="SELECT u.`*` FROM SCHEDULE AS u WHERE u.week=?1",nativeQuery = true)
    List<Schedule> findScheduleByWeek(int week);

    /*
     * 通过地址进行查询，参数为address,
     * 相当于JPQL：select p from Person p where p.address=?1
     * */
    @Query("select s from Schedule s where s.week=?1")
    List<Schedule> findByWeek(int week);

}
