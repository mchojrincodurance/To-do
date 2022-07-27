package com.codurance.todo;

public class TaskListImplementation implements TaskList {
    private final TaskRepository taskRepository;

    public TaskListImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(String description) {
        taskRepository.add(new Task(description));
//        throw new UnsupportedOperationException();
    }

    @Override
    public void completeTask(String description) {
//        throw new UnsupportedOperationException();
    }

    public void showTasks() {
//        throw new UnsupportedOperationException();
    }
}
