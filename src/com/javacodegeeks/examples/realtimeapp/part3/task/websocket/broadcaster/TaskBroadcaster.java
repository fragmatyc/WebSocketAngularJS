package com.javacodegeeks.examples.realtimeapp.part3.task.websocket.broadcaster;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.javacodegeeks.examples.realtimeapp.part3.client.repository.ClientRepository;
import com.javacodegeeks.examples.realtimeapp.part3.task.domain.Task;
import com.javacodegeeks.examples.realtimeapp.part3.websocket.broadcaster.Broadcaster;

@Component
public class TaskBroadcaster implements Broadcaster<Task> {
	@Autowired
	private ClientRepository clients;
	private Gson gson;
	
	@PostConstruct
	public void init() {
		this.gson = new Gson();
	}
	
	@Override
	public void broadcast(List<Task> task) {
		this.clients.forEach(client -> {
			try {
				client.sendText(this.gson.toJson(task));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
