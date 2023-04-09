package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Example;

public interface ExampleRepository extends JpaRepository<Example, Long> {
	

}
