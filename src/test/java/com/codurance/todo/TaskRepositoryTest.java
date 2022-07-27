package com.codurance.todo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class TaskRepositoryTest {

    public static final String A_TASK = "A task";

    @Test
    public void allow_adding_tasks() {
        TaskRepository taskRepository = new TaskRepository();
        Task task = new Task(A_TASK);
        taskRepository.add(task);
        assertThat(taskRepository.getTasks(), contains(task));
    }
}