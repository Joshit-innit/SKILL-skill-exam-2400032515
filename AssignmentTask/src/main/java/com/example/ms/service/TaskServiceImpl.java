package com.example.ms.service;

import java.util.List;
import java.util.Optional;


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
	public Optional<EMI> updateEMI(long id, EMI emi) {
		return repo.findById(id).map(existing -> {
			existing.setName(emi.getName());
			existing.setType(emi.getType());
			existing.setStatus(emi.isStatus());
			existing.setLocation(emi.getLocation());
			return repo.save(existing);
		});
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
