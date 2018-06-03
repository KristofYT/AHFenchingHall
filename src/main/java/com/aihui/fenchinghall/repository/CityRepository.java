package com.aihui.fenchinghall.repository;

import com.aihui.fenchinghall.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cityRepository")
public interface CityRepository extends JpaRepository<City,Integer> {





}
