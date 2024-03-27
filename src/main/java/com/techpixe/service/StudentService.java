package com.techpixe.service;

import java.util.List;

import com.techpixe.entity.Student;

public interface StudentService 
{
	Student save(String studentName, Long parent);
	
	Student getById(Long id);
	
	List<Student> all();
	
	void deleteById(Long id);
	
	Student update(Long id, String studentName);
}
