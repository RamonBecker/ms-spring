package com.devsuperior.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hrworker.entities.Worker;

public interface WorkerRepositoy extends JpaRepository<Worker, Long>{
	
}
