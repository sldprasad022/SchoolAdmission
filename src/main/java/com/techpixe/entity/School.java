package com.techpixe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schoolId;
	
	private Long standard;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="studentId")
	private Student student;
	
}
