package com.techpixe.service;

import java.util.List;

import com.techpixe.entity.School;

public interface SchoolService 
{
	School admission(Long standard, Long student);
	
	School getById(Long id);
	
	List<School> getAll();
	
	void deleteById(Long id);
	
	School update(Long id, Long standard);
}
