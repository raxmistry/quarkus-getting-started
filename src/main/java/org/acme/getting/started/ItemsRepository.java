package org.acme.getting.started;

import java.util.UUID;

public interface ItemsRepository {
    UUID add(TodoItem item);

    TodoItem getItemById(UUID itemId);

    void update(UUID itemId, String newDescription);

    TodoItem deleteItem(UUID itemId);
}
