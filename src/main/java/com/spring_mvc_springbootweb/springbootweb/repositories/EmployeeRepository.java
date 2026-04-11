package com.spring_mvc_springbootweb.springbootweb.repositories;

import com.spring_mvc_springbootweb.springbootweb.dto.EmployeeDTO;
import com.spring_mvc_springbootweb.springbootweb.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

//    List<EmployeeEntity> findByName(String name);


}
