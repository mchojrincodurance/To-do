### Problem description

Build a simple To-do List with the following features:

- Add a task
- Mark a task as completed
- Print task list

## Acceptance criteria

_Given_ I have an empty task list

_And_ I add a new task “Buy milk”

_And_ I add a new task “Feed the dog”

_And_ I add a new task “Boil eggs”

_And_ I mark “Feed the dog” as completed

_When_ I print my task list

_Then_ I should see:

```
Task            | Completed
Buy milk        |
Feed the dog    |   x
Boil eggs       |
```

## Starting point and constraints

Start with a class with the following interface:

```java
interface TaskListInterface {
     void addTask(String description);
     void completeTask(TaskId id);
     void showTasks();
}
```
