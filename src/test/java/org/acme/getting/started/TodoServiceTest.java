package org.acme.getting.started;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoServiceTest {

    TodoService todoService = new TodoService(new InMemoryItemsRepository());

    @Test
    void should_add_item() {
        UUID itemId = todoService.addItem(new TodoItem("test1"));
        TodoItem insertedItem = todoService.getItem(itemId);
        assertEquals("test1", insertedItem.getDescription());
    }

    @Test
    void should_update_item() {
        UUID itemId = todoService.addItem(new TodoItem("test1"));
        todoService.updateItem(itemId, new TodoItem("test2"));
        TodoItem insertedItem = todoService.getItem(itemId);
        assertEquals("test2", insertedItem.getDescription());
    }
}