package com.student.respo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.Entity.EStudent;

@Repository
public interface iservice {
	
	public boolean SaveRegister(EStudent student);
	
	public List<EStudent> Registed();
}
