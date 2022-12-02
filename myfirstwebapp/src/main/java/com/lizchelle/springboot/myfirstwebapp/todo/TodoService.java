package com.lizchelle.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "Lizchelle", "Create Portfolio1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Learn iOS1 ", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Learn Python1 ", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Web Fundamentals1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Learn Photoshop1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Learn Adobe Illustrator1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Certificate Adobe Illustrator1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Learn Java1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Certificate Java1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Google Certificate1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Learn Canvas1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Lizchelle", "Learn Social Media - Instagram1", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean Done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, Done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		//todo.getId() == id
		//todo -> todo.getId() == id
		Predicate<? super Todo> predicate
		= todo -> todo.getId() == id;
		todos.removeIf(predicate);
		
		
		
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate
		=todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
		
	
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}

}
