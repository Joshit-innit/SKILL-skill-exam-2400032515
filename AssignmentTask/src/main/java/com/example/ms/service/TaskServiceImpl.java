package com.example.ms.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.ms.entity.EMI;
import com.example.ms.repository.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService {
	
	
	final TaskRepo repo;

	TaskServiceImpl(TaskRepo repo) {
		this.repo = repo;
	}
	@Override
	public EMI addEMI(EMI emi) {
		// TODO Auto-generated method stub
		return repo.save(emi);
		
	}

	@Override
	public List<EMI> getAllEMI() {
		return repo.findAll();
	}

	@Override
	public boolean deleteById(long id) {
		if (!repo.existsById(id)) {
			return false;
		}
		repo.deleteById(id);
		return true;
	}

	
	
}
