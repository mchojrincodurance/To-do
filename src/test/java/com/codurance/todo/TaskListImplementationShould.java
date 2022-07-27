package com.codurance.todo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaskListImplementationShould {

    public static final String FIRST_TASK = "A task";
    @Mock
    TaskRepository taskRepository;

    @Test
    public void allow_adding_task() {
        Task task = new Task(FIRST_TASK);

        TaskListImplementation taskList = new TaskListImplementation();

        taskList.addTask(FIRST_TASK);

        verify(taskRepository).add(eq(task));
    }
}