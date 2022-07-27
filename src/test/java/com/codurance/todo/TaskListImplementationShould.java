package com.codurance.todo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaskListImplementationShould {

    public static final String FIRST_TASK = "A task";
    @InjectMocks
    TaskListImplementation taskList;
    @Mock
    TaskRepository taskRepository;

    @Test
    public void allow_adding_task() {
        Task task = new Task(FIRST_TASK);

        taskList.addTask(FIRST_TASK);

        verify(taskRepository).add(eq(task));
    }
}