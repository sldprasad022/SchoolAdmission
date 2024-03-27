package com.techpixe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techpixe.entity.School;
import com.techpixe.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController 
{
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/save/{id}")
	public ResponseEntity<School> admission(@RequestParam Long standard, @PathVariable("id") Long student)
	{
		School saved= schoolService.admission(standard, student);
		return new ResponseEntity<School>(saved, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id)
	{
		School getById = schoolService.getById(id);
		return ResponseEntity.ok(getById);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<School>> all()
	{
		List<School> all = schoolService.getAll();
		return new ResponseEntity<List<School>>(all, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id)
	{
		School deleteId = schoolService.getById(id);
		if (deleteId==null) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			schoolService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
	}
	
	
	@PutMapping("/update/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id,
                                                @RequestParam Long standard) {
        School updatedSchool = schoolService.update(id, standard);
        return new ResponseEntity<>(updatedSchool, HttpStatus.OK);
    }
	
	
}
