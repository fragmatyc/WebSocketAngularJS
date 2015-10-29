package com.javacodegeeks.examples.realtimeapp.part3.task.repository;

import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javacodegeeks.examples.realtimeapp.part3.task.websocket.broadcaster.TaskBroadcaster;

@Component
public class TaskRepositoryObserver implements Observer {
	@Autowired
	private TaskBroadcaster broadcaster;
	
	@Override
	public void update(Observable repository, Object param) {
		TaskRepository repo = (TaskRepository) repository;
		this.broadcaster.broadcast(repo.getAll());
	}

}
