package com.techpixe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.School;
import com.techpixe.entity.Student;
import com.techpixe.repository.SchoolRepository;
import com.techpixe.repository.StudentRepository;
import com.techpixe.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService
{
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public School admission(Long standard, Long student)
	{
		
		Student studentId = studentRepository.findById(student).orElseThrow(()-> new RuntimeException("Student id is not present"+student));
		if (studentId!=null)
		{
			School school = new School();
			school.setStandard(standard);
			school.setStudent(studentId);
			return schoolRepository.save(school);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Parent Id is not Present "+studentId);
		}
	}

	@Override
	public School getById(Long id) 
	{
		return schoolRepository.findById(id).orElseThrow(()-> new RuntimeException("Id is not present"+id));
	}

	@Override
	public List<School> getAll()
	{
		List<School> fetchAll = schoolRepository.findAll();
		if (fetchAll.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No records are present");
		}
		return fetchAll;
	}

	@Override
	public void deleteById(Long id) 
	{
		schoolRepository.deleteById(id);
	}
	
	 @Override
	    public School update(Long id, Long standard) {
	        Optional<School> optionalSchool = schoolRepository.findById(id);
	        if (optionalSchool.isPresent()) {
	            School school = optionalSchool.get();
	            school.setStandard(standard);
	            return schoolRepository.save(school);
	        } else {
	            // Handle the case where the school with the given id is not found
	            throw new RuntimeException("School with id " + id + " not found");
	        }
	    }

}
