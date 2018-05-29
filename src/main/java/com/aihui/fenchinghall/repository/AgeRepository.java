package com.aihui.fenchinghall.repository;

import com.aihui.fenchinghall.model.Age;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ageRepository")
public interface AgeRepository extends JpaRepository<Age,Integer> {



}
