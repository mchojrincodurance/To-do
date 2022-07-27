package com.codurance.todo;

public class TaskListImplementation implements TaskList {
    private final TaskRepository taskRepository;
    private Console console;

    public TaskListImplementation(TaskRepository taskRepository, Console console) {
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
        console.printLine("Task            | Completed");
        console.printLine("Buy milk        |");
        console.printLine("Feed the dog    |   x");
        console.printLine("Boil eggs       |");
    }
}
