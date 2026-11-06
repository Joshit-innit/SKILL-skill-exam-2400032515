package com.example.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms.entity.EMI;

@Repository
public interface TaskRepo  extends JpaRepository<EMI, Long> {
	List<EMI> findByName(String Name);
	List<EMI> findByType(String type);
	
}
