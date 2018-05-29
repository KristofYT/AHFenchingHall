package com.aihui.fenchinghall.repository;

import com.aihui.fenchinghall.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("hallRepository")
public interface HallRepository extends JpaRepository<Hall,Integer> {



}
