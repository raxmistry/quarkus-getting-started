package org.acme.getting.started;

public interface ItemsRepository {
    Integer add(TodoItem item);

    TodoItem getItemById(Integer itemId);

    void update(Integer itemId, String newDescription);

    boolean deleteItem(Integer itemId);
}
