package com.aihui.fenchinghall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aihui.fenchinghall.model.Coach;

@Repository("coachRepository")
public interface CoachRepository extends JpaRepository<Coach,Integer> {

}
