package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DiagnosticCenter;
import com.example.model.Users;
import com.example.service.CenterServiceImpl;
@CrossOrigin(origins = "http://localhost:3002")
@RestController
@RequestMapping("/center")
public class CenterController {
	
	@Autowired
	CenterServiceImpl cent;
	
	@PostMapping("/addcenter")
	public DiagnosticCenter addCenter(@Valid @RequestBody DiagnosticCenter diagCenter) {
		return cent.saveCenter(diagCenter);
	}
	
	@GetMapping("/getcenters")
	public List<DiagnosticCenter> getCenters() {
		return cent.getAll();
	}
	
	@DeleteMapping("/{centerId}")
	public String deleteCenter(@PathVariable("centerId") Integer centerId) {
		return cent.removeCenter(centerId);
	}


	
	
}
