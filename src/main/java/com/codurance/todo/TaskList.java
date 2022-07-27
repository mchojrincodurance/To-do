package com.codurance.todo;

public interface TaskList {
    void addTask(String description);

    void completeTask(int id);

    void showTasks();
}
