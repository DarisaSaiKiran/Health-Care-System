package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.DiagnosticCenter;
import com.example.model.Users;
import com.example.repository.DiagnosticCenterRepository;

@Service
public class CenterServiceImpl {
	
	@Autowired
	DiagnosticCenterRepository centerRepo;
	
	public DiagnosticCenter saveCenter(DiagnosticCenter center) {
		return centerRepo.save(center);
	}
	
	public List<DiagnosticCenter> getAll() {

		return centerRepo.findAll();

	}
	
	public String removeCenter(Integer centerId) {
		DiagnosticCenter diag = centerRepo.getReferenceById(centerId);
		if (centerRepo.existsById(centerId)) {
			centerRepo.deleteById(centerId);
			return "Center " + centerId + " deleted successfully";
		} else
			return "Center does not exists";

	}
	
	

	
}
