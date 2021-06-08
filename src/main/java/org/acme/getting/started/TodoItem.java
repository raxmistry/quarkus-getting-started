package org.acme.getting.started;

public class TodoItem {
    public TodoItem(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }
}
