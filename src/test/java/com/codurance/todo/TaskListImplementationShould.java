package com.codurance.todo;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TaskListImplementationShould {

    public static final String FIRST_TASK = "A task";

    @Test
    public void allow_adding_task() {
        TaskRepository taskRepository = mock(TaskRepository.class);
        Task task = new Task(FIRST_TASK);

        TaskListImplementation taskList = new TaskListImplementation();

        taskList.addTask(FIRST_TASK);

        verify(taskRepository).add(eq(task));
    }
}