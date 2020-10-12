package br.com.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.task.domain.entity.Task;
import br.com.task.service.TaskService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService service; 
	
	@GetMapping("/{id}")
	public Optional<Task> getTaskById(@PathVariable Integer id) {
		return service.findById(id);

	}
	
	@GetMapping
	public List<Optional<Task>> getTaskAll() {
		return service.findAll();

	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Optional<Task>  saveTask(@RequestBody Task task) {
		return service.save(task);

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);		
	}
	
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Task task) {
		service.update(task);
	}
	
	
}
