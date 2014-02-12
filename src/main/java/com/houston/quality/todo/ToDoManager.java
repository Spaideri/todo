package com.houston.quality.todo;

import java.util.Collections;
import java.util.List;

public class ToDoManager implements IToDoManager {

	private List<ToDoItem> items;

	private IToDoDao dao;

	public ToDoManager(List<ToDoItem> list, IToDoDao dao) {
		this.items = list;
		this.dao = dao;
	}

	public void addToDoItem(ToDoItem item) {
		dao.save(item);
	}

	public void removeToDoItem(ToDoItem item) {
		items.remove(item);
	}

	public List<ToDoItem> getAllToDoItems() {
		return Collections.unmodifiableList(items);
	}

}
