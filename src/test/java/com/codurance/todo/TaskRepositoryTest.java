package com.codurance.todo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    public static final String A_TASK = "A task";
    private final TaskRepository taskRepository = new TaskRepository();

    @Test
    public void allow_adding_tasks() {
        Task task = buildTask();
        taskRepository.add(task);
        assertThat(taskRepository.getTasks(), contains(task));
    }

    private static Task buildTask() {
        return new Task(A_TASK);
    }

    @Test
    public void find_tasks_if_present() {
        Task task = buildTask();
        taskRepository.add(task);

        Task foundTask = taskRepository.findTask(A_TASK);
        assertEquals(foundTask, task);
    }

    @Test
    public void return_null_if_task_not_found() {
        assertNull(taskRepository.findTask(buildTask().toString()));
    }
}