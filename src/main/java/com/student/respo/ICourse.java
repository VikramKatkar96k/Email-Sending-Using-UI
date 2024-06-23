package com.student.respo;

import org.springframework.data.repository.CrudRepository;

import com.student.Entity.ECourse;

public interface ICourse extends CrudRepository<ECourse, Integer> 
{

}
