package com.houston.quality.todo;

import java.util.List;

public interface IToDoManager {

	void addToDoItem(ToDoItem item);

	void removeToDoItem(ToDoItem item);

	List<ToDoItem> getAllToDoItems();
}
