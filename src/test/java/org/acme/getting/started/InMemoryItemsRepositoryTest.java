package org.acme.getting.started;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryItemsRepositoryTest {

    InMemoryItemsRepository repository;

    @BeforeEach
    void setup() {
        repository = new InMemoryItemsRepository();
    }

    @Test
    void should_addItem() {
        String description = "test1";
        UUID itemId = repository.add(new TodoItem(description));
        assertNotNull(itemId);
        TodoItem actual = repository.getItemById(itemId);
        assertEquals(actual.getDescription(), description);
    }

    @Test
    void should_addAndGet_multipleItems() {
        String description = "item1";
        String description2 = "item2";

        UUID item1 = repository.add(new TodoItem(description));
        UUID item2 = repository.add(new TodoItem(description2));

        assertEquals(repository.getItemById(item1).getDescription(), description);
        assertEquals(repository.getItemById(item2).getDescription(), description2);
    }

    @Test
    void should_updateItem() {
        String description = "test1";
        UUID itemId = repository.add(new TodoItem(description));

        String newDescription = "A new description";
        repository.update(itemId, newDescription);
        assertNotEquals(repository.getItemById(itemId).getDescription(), description);
        assertEquals(repository.getItemById(itemId).getDescription(), newDescription);
    }

    @Test
    void should_delete_item() {
        String description = "test1";
        UUID itemId = repository.add(new TodoItem(description));
        var deletedItem = repository.deleteItem(itemId);
        assertEquals(itemId, deletedItem.getId());
    }
}