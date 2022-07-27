package com.codurance.todo;

public class Task {
    private final String description;

    public Task(String description) {

        this.description = description;
    }

    public boolean equals(Task otherTask) {
        return this.description.equals(otherTask.description);
    }
}
