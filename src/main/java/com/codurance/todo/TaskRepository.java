package com.codurance.todo;

import java.util.ArrayList;

public class TaskRepository {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void add(Task task) {
        tasks.add(task);
    }

    public Task findTask(String soughtTask) {
        return tasks.stream().filter( task -> soughtTask.equals(task) ).findAny().orElse(null);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
