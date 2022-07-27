### Problem description

Build a simple To-do List with the following features:

- Add a task
- Mark a task as completed
- Print task list

## Acceptance criteria

Task list should show tasks in this format:

Task            | Completed
Buy milk        |
Feed the dog    |   x
Boil eggs       |

## Starting point and constraints

Start with a class with the following interface:

```java
interface TaskList {
     void addTask(String description);
     void completeTask(TaskId id);
     void showTasks();
}
```


Given I have an empty task list
And I add a new task "Buy milk"
When I print my task list
Then I see:

Task            | Completed
Buy milk        |

====

Given I have a task list containing a task "Buy milk"
And another task "Feed the dog"
And I check the task "Feed the dog"
When I print my task list
Then I see:

Task            | Completed
Buy milk        |
Feed the dog    |   x

====

