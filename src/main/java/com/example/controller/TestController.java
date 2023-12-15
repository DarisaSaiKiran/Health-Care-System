package com.example.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ListEmptyException;
import com.example.model.Test;
import com.example.service.TestService;

@RestController
@RequestMapping("api/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	
	@PostMapping("/addtest")
	public Test addTest(@RequestBody Test test) {
		return testService.saveTest(test);
	}
	
	
	

	@GetMapping("/viewtests")
	public List<Test> viewTests() throws ListEmptyException {
		if (testService.viewAllTests().isEmpty())
			throw new ListEmptyException();
		return testService.viewAllTests();
}
	
	@DeleteMapping(value = "/{testId}")
	public String deleteTest(@PathVariable int testId) {
		return testService.removeTestId(testId);
	}


}
