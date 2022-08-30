package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {
    @Test
    void should_multiple_words_as_name() {
        final var taskRepository = new TaskRepository() {
            private Task task;

            @Override
            List<String> createTask(Task task) {
                this.task = task;
                return List.of();
            }

            public String getTaskName() {
                return this.task.getName();
            }
        };
        final AddCommand command = new AddCommand(taskRepository, "add", "fizz", "buzz");
        command.execute();

        final var taskName = taskRepository.getTaskName();
        assertEquals("fizz buzz", taskName);
    }
}