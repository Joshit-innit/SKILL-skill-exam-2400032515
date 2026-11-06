package com.example.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms.entity.EMI;
import com.example.ms.service.TaskService;

@RestController
@RequestMapping("/emi")
public class TaskController {
	@Autowired
	private TaskService service;
	
	@GetMapping("/home")
	public String home () {
		return "Home Page";
	}
	
	@PostMapping("/add")
	public ResponseEntity<EMI> addCenter(@RequestBody EMI emi) {
		return new ResponseEntity<>(service.addEMI(emi), HttpStatus.CREATED);
	}
	
	@GetMapping("/DisplayAll")
	 public ResponseEntity<List<EMI>> displayAllEMI() {
		List<EMI> centers = service.getAllEMI();
		return ResponseEntity.ok(centers);
	}
	
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id) {
		if (!service.deleteById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EMI not found.");
		}
		return ResponseEntity.ok("EMI deleted successfully.");
	}
	
	
}
