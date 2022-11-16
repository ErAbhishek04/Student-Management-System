package com.abhishek.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.entity.Student;
import com.abhishek.repository.StudRepo;

import antlr.collections.List;

@Service


public class StudService {
	
	@Autowired
	private StudRepo repo;
	public void addStud(Student e) {
		
		repo.save(e);
	}
public java.util.List<Student> getAllStud()
{
	return  repo.findAll();
}

public Student getStudById(int id) {
	
	Optional<Student> e = repo.findById(id);
	if(e.isPresent()) {
		
		return e.get();
	}
	return null;
}

public void deleteEmp(int id) {
	
	 repo.deleteById(id);
}

}
