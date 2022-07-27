package com.codurance.todo;

public interface TaskListInterface {
    void addTask(String description);

    void completeTask(String description);

    void showTasks();
}
