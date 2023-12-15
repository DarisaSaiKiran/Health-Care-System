package com.example.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, BigInteger> {

}
