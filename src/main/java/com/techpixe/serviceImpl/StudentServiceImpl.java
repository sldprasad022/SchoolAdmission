package com.techpixe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.dto.ErrorDto;
import com.techpixe.entity.Parent;
import com.techpixe.entity.Student;
import com.techpixe.repository.ParentRepository;
import com.techpixe.repository.StudentRepository;
import com.techpixe.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ParentRepository parentRepository;


	@Override
	public Student save(String studentName, Long parent)
	{
		Parent parentId= parentRepository.findById(parent).orElseThrow(()-> new RuntimeException("Parent is not present"+parent));
		if (parentId!=null) 
		{
			Student student = new Student();
			student.setStudentName(studentName);
			student.setParent(parentId);
			return studentRepository.save(student);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Parent Id is not Present "+parent);
		}
	}


	@Override
	public Student getById(Long id) 
	{
		return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student id is not present"+id));
	}

	@Override
	public List<Student> all() 
	{
		List<Student> fetchAll = studentRepository.findAll();
		if (fetchAll.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No records are present");
		}
		return fetchAll;
	}


	@Override
	public void deleteById(Long id)
	{
		studentRepository.deleteById(id);
	}


	
	
	@Override
    public Student update(Long id, String studentName) {
        Student existingStudent = studentRepository.findById(id)
                                                   .orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));
        existingStudent.setStudentName(studentName);
        return studentRepository.save(existingStudent);
    }
	
	
	

	
}
