package com.techpixe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpixe.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long>
{

	Parent save(String parentName);

}
