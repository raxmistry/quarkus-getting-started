package org.acme.getting.started;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void should_delete_item() {
        UUID item1 = todoService.addItem(new TodoItem("item1"));
        TodoItem deletedItem = todoService.deleteItem(item1);
        assertEquals(item1, deletedItem.id);
    }

    @Test
    void delete_shouldRaiseError_ifItemDoesNotExist() {
        assertThrows(ItemNotFoundException.class, () -> todoService.deleteItem(UUID.randomUUID()));
    }
}