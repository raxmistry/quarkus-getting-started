package org.acme.getting.started;

import java.util.UUID;

public class TodoService {


    private ItemsRepository itemsRepository;

    public TodoService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public UUID addItem(TodoItem item) {
        return itemsRepository.add(item);
    }

    public TodoItem getItem(UUID itemId) {
        return itemsRepository.getItemById(itemId);
    }

    public void updateItem(UUID itemId, TodoItem item) {
        itemsRepository.update(itemId, item.getDescription());
    }

    public TodoItem deleteItem(UUID id) {
        return itemsRepository.deleteItem(id);
    }
}
