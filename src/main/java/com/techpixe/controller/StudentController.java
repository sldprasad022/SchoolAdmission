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

import com.techpixe.entity.Student;
import com.techpixe.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveStudent/{id}")
	public ResponseEntity<Student> save(@RequestParam String studentName, @PathVariable("id") Long parent)
	{
		Student saved = studentService.save(studentName, parent);
		return new ResponseEntity<Student>(saved, HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id)
	{
		Student fetchById = studentService.getById(id);
		return ResponseEntity.ok(fetchById);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> all()
	{
		List<Student> fetchAll = studentService.all();
		return new ResponseEntity<List<Student>>(fetchAll, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id)
	{
		Student studentId = studentService.getById(id);
		if (studentId==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			studentService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestParam String studentName) {
        Student updatedStudent = studentService.update(id, studentName);
        return ResponseEntity.ok(updatedStudent);
    }
	
}
