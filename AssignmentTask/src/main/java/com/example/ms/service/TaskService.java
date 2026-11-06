package com.example.ms.service;

import java.util.List;
import java.util.Optional;

import com.example.ms.entity.EMI;

public interface TaskService {
	public EMI addEMI(EMI emi);
	public List<EMI> getAllEMI();
	public Optional<EMI> updateEMI(long id, EMI emi);
	public boolean deleteById(long id);
}
