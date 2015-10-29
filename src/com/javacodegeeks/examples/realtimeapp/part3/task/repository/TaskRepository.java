package com.javacodegeeks.examples.realtimeapp.part3.task.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javacodegeeks.examples.realtimeapp.part3.repository.TaskAppRepository;
import com.javacodegeeks.examples.realtimeapp.part3.task.domain.Task;

@Repository
public abstract class TaskRepository extends TaskAppRepository<String, Task> {
	@Autowired
	private BeanFactory factory;
	
	@PostConstruct
	public void init() {
		this.addObserver(this.factory.getBean(TaskRepositoryObserver.class));
	}
}
