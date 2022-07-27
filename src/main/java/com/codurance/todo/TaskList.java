package com.codurance.todo;

import java.util.ArrayList;

public class TaskList implements TaskListInterface {
    private final TaskRepository taskRepository;
    private final Console console;

    public TaskList(TaskRepository taskRepository, Console console) {
        this.taskRepository = taskRepository;
        this.console = console;
    }

    @Override
    public void addTask(String description) {
        taskRepository.add(new Task(description));
    }

    @Override
    public void completeTask(String description) {
        Task task = taskRepository.findTask(description);

        if (null != task) {
            task.complete();
        }
    }

    public void showTasks() {
        printHeader();
        printTasks();
    }

    private void printTasks() {
        for( Task task : getTasks() ) {
            printTask(task);
        }
    }

    private ArrayList<Task> getTasks() {
        return taskRepository.getTasks();
    }

    private void printTask(Task task) {
        console.printLine(task.toString());
    }

    private void printHeader() {
        console.printLine("Task            | Completed");
    }
}
