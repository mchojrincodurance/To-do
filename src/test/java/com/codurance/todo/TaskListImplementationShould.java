package com.codurance.todo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskListImplementationShould {

    public static final String FIRST_TASK = "A task";
    @Mock Console console;
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

    @Test
    public void should_allow_marking_tasks_as_completed() {
        Task firstTask = spy(Task.class);
        when(taskRepository.findTask(FIRST_TASK)).thenReturn(firstTask);

        taskList.addTask(FIRST_TASK);
        taskList.completeTask(FIRST_TASK);

        verify(taskRepository).findTask(FIRST_TASK);
        verify(firstTask).complete();
    }

    @Test
    public void should_not_break_if_task_not_found() {
        taskList.completeTask(FIRST_TASK);
        assertTrue(true);
    }

    @Test
    public void use_console_when_printing() {
        taskList.showTasks();
        verify(console, atLeastOnce()).printLine(anyString());
    }
}