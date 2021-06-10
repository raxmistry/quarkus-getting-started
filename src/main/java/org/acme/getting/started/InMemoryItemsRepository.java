package org.acme.getting.started;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryItemsRepository implements ItemsRepository {
    
    Map<UUID, TodoItem> items;

    public InMemoryItemsRepository() {
        items = new HashMap<>();
    }

    @Override
    public UUID add(TodoItem item) {
        UUID key = item.getId();
        items.put(key, item);
        return key;
    }

    @Override
    public TodoItem getItemById(UUID itemId) {
        return items.get(itemId);
    }

    @Override
    public void update(UUID itemId, String newDescription) {
        items.put(itemId, new TodoItem(newDescription));
    }

    @Override
    public TodoItem deleteItem(UUID itemId) {
        Optional<TodoItem> removed = Optional.ofNullable(items.remove(itemId));
        return removed.orElseThrow(() -> new ItemNotFoundException());
    }
}
