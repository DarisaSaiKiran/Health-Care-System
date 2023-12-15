package com.example.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table
@Data
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private BigInteger id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime dateTime;
	@Column(name = "approved", columnDefinition = "boolean default true")
	private boolean approved;
	
	

}
