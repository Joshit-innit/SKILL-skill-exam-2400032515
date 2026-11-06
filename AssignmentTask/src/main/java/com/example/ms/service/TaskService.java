package com.example.ms.service;

import java.util.List;

import com.example.ms.entity.EMI;

public interface TaskService {
	public EMI addEMI(EMI emi);
	public List<EMI> getAllEMI();
	public boolean deleteById(long id);
}
