package com.codurance.todo;

public class TaskListImplementation implements TaskList {
    private final TaskRepository taskRepository;

    public TaskListImplementation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(String description) {
        taskRepository.add(new Task(description));
    }

    @Override
    public void completeTask(String description) {
        Task task = taskRepository.findTask(description);

        task.complete();
    }

    public void showTasks() {
//        throw new UnsupportedOperationException();
    }
}
