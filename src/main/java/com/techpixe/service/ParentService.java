package com.techpixe.service;

import java.util.List;
import java.util.Optional;

import com.techpixe.entity.Parent;

public interface ParentService 
{
	Parent save(String parentName);
	
	Parent getById(Long id);
	
	List<Parent> all();
	
	void deleteById(Long id);
	
//	Optional<?> update(Long id,String parentName);
	
	Parent update(Long id, String parentName); 

	
}
