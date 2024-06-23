package com.student.Entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Entity.EStudent;
import com.student.respo.EStudentRepository;
import com.student.respo.iservice;

@Service
public class impService implements iservice {

	@Autowired
	EStudentRepository repository;
	public boolean SaveRegister(EStudent student) {
		EStudent save = repository.save(student);
		return true;
	}
	@Override
	public List<EStudent> Registed() {
		Iterable<EStudent> findAll = repository.findAll();
		return (List<EStudent>) findAll;
	}
	
}
