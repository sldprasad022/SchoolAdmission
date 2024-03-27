package com.techpixe.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="child")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	private String studentName;
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private Parent parent;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "photoGrapher", fetch = FetchType.EAGER)
//	private List<Event> event = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy="student", fetch= FetchType.EAGER)
	private List<School> all = new ArrayList<>();
	

}
