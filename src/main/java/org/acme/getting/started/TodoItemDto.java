package org.acme.getting.started;

public class TodoItemDto {
    String description;

    public TodoItemDto(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
