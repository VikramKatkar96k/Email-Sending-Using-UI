package com.student.respo;

import org.springframework.data.repository.CrudRepository;

import com.student.Entity.EStudent;

public interface EStudentRepository extends CrudRepository<EStudent, Integer> {
}
