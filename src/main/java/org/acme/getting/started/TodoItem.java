package org.acme.getting.started;

import java.util.UUID;

public class TodoItem {
    public UUID id;

    public TodoItem(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }
}
