package com.codurance.todo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskShould {

    public static final String TASK_DESCRIPTION = "A task";

    @ParameterizedTest
    @CsvSource({
            "true",
            "false"
    })
    public void know_when_its_completed(boolean isCompleted) {
        Task task = buildTask(isCompleted);

        assertEquals(isCompleted, task.isCompleted());
    }

    private static Task buildTask(boolean isCompleted) {
        Task task = new Task(TASK_DESCRIPTION);

        if (isCompleted) {
            task.complete();
        }

        return task;
    }

    @ParameterizedTest
    @CsvSource({
            "true",
            "false"
    })
    public void convert_itself_to_string(boolean isCompleted) {
        Task task = buildTask(isCompleted);

        assertEquals(TASK_DESCRIPTION + "|" + (isCompleted ? "x" : ""), task.toString());
    }
}