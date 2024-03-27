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

import com.techpixe.entity.Parent;
import com.techpixe.service.ParentService;

@RestController
@RequestMapping("/parent")
public class ParentController 
{
	@Autowired
	private ParentService parentService;
	
	@PostMapping("/save")
	public ResponseEntity<Parent> saveParent(@RequestParam String parentName)
	{
		Parent save = parentService.save(parentName);
		return new ResponseEntity<Parent>(save, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id)
	{
		Parent fetchById = parentService.getById(id);
		return ResponseEntity.ok(fetchById);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Parent>> all()
	{
		List<Parent> fetchAll = parentService.all();
		return new ResponseEntity<List<Parent>>(fetchAll, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id)
	{
		Parent parent= parentService.getById(id);
		if (parent==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else
		{
			parentService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Parent> updateParent(@PathVariable Long id, @RequestParam String parentName) {
        Parent updatedParent = parentService.update(id, parentName);
        return new ResponseEntity<>(updatedParent, HttpStatus.OK);
    }
}
