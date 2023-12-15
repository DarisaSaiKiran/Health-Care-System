package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.DiagnosticCenter;
import com.example.model.Test;
import com.example.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	TestRepository testRepo;
	
	public Test saveTest(Test test) {
		return testRepo.save(test);
	}

	public List<Test> viewAllTests() {
			return (List<Test>) testRepo.findAll();
		}
	
	
	public String removeTestId(int testId) {
		if (testRepo.existsById(testId)) {
			Test test = testRepo.getReferenceById(testId);
			testRepo.deleteById(testId);
			return "Test " + testId + " Deleted";

		} else {
			return "Test not Found";

		}
	}

}
