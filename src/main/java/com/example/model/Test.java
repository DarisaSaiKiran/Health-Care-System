package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	//@NotBlank(message = "username cannot be null")
	private String testName;
	
	//private DiagnosticCenter centerId;
	
	// @ManyToOne
	//    private List<DiagnosticCenter> centers = new ArrayList<>();
	

}
