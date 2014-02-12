package com.houston.quality.todo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ToDoManagerTest {

	private static final String TODO_ITEM_NAME = "Do groceries";

	@Mock
	private IToDoManager manager;

	@Mock
	private IToDoDao dao;

	private List<ToDoItem> list;

	@Before
	public void setup() {
		list = new ArrayList<ToDoItem>();
		manager = new ToDoManager(list, dao);
	}

	@Test
	public void managerShouldExist() {
		assertNotNull(manager);
	}

	@Test
	public void shouldGetAllItems() {
		ToDoItem toDoItem = new ToDoItem(TODO_ITEM_NAME);

		list.add(toDoItem);

		List<ToDoItem> allToDoItems = manager.getAllToDoItems();

		assertTrue(allToDoItems.contains(toDoItem));
	}

	@Test
	public void shouldAddNewToDoItem() {
		ToDoItem toDoItem = new ToDoItem(TODO_ITEM_NAME);

		manager.addToDoItem(toDoItem);

		verify(dao).save(toDoItem);
	}

	@Test
	public void shouldRemoveItem() {
		ToDoItem toDoItem = new ToDoItem(TODO_ITEM_NAME);
		ToDoItem toDoItem2 = new ToDoItem(TODO_ITEM_NAME);

		list.add(toDoItem);
		list.add(toDoItem2);

		manager.removeToDoItem(toDoItem2);

		List<ToDoItem> allToDoItems = manager.getAllToDoItems();

		assertFalse(allToDoItems.contains(toDoItem2));
	}
}
