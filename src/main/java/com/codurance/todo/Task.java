package com.codurance.todo;

public class Task {
    private final String description;

    public Task(String description) {

        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }

    public boolean isCompleted() {
        return false;
    }
}
