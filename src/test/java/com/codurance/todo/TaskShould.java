package com.codurance.todo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskShould {
    @ParameterizedTest
    @CsvSource({
            "true",
            "false"
    })
    public void know_when_its_completed(boolean isCompleted) {
        Task task = new Task("a task");

        if (isCompleted) {
            task.complete();
        }

        assertEquals(isCompleted, task.isCompleted());
    }
}