package org.acme.getting.started;

import java.util.ArrayList;
import java.util.List;

public class InMemoryItemsRepository implements ItemsRepository {

    //TODO: This is a bad collection to use
    List<TodoItem> items;

    public InMemoryItemsRepository() {
        items = new ArrayList<>();
    }

    @Override
    public Integer add(TodoItem item) {
        items.add(item);
        return items.size() - 1;
    }

    @Override
    public TodoItem getItemById(Integer itemId) {
        return items.get(itemId);
    }

    @Override
    public void update(Integer itemId, String newDescription) {
        items.add(itemId, new TodoItem(newDescription));
    }

    @Override
    public boolean deleteItem(Integer itemId) {
        items.remove(itemId.intValue());
        return true;
    }
}
