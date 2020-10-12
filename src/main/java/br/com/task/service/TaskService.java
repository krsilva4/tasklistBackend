package br.com.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.task.controller.repository.TaskRepository;
import br.com.task.domain.entity.Task;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public Optional<Task> findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Optional<Task>> findAll() {			
		return converteOption(repository.findAll());
	}
	
	public Optional<Task> save(Task task) {
		return Optional.of(repository.save(task));
	}
	
	public void delete(Integer id) {
		 repository.deleteById(id);
	}
	
	public void update(Task task) {
		 repository.save(task);
	}
	
	private List<Optional<Task>> converteOption(List<Task> listTask) {
		List<Optional<Task>> lisOptionals = new ArrayList<>(); 
		for(Task task: listTask) {
			lisOptionals.add(Optional.of(task));
		}
		
		return lisOptionals;
	}

}
