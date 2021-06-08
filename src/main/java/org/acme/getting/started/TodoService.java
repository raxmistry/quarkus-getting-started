package org.acme.getting.started;

public class TodoService {


    private ItemsRepository itemsRepository;

    public TodoService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Integer addItem(TodoItem item) {
        return itemsRepository.add(item);
    }

    public TodoItem getItem(Integer itemId) {
        return itemsRepository.getItemById(itemId);
    }

    public void updateItem(Integer itemId, TodoItem item) {
        itemsRepository.update(itemId, item.getDescription());
    }
}
