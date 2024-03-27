package com.techpixe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpixe.entity.School;

public interface SchoolRepository extends JpaRepository<School, Long>
{

}
