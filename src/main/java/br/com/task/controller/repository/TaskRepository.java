package br.com.task.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.task.domain.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
}
