package com.javacodegeeks.examples.realtimeapp.part3.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.examples.realtimeapp.part3.task.domain.Task;
import com.javacodegeeks.examples.realtimeapp.part3.task.repository.TaskRepository;

@RestController
public class TaskRestController {
	@Autowired
	private TaskRepository taskRepository;
	
	@RequestMapping(path = "/tasks", method = RequestMethod.GET)
	public @ResponseBody List<Task> getTasks() {
		return this.taskRepository.getAll();
	}
	
	@RequestMapping(path = "/tasks", method = RequestMethod.POST)
	public void addTask(@RequestBody Task task) {
		this.taskRepository.add(task);
	}
}
