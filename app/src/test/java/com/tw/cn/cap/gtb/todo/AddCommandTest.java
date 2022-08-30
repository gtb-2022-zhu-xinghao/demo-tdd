package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddCommandTest {

    private MyTaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new MyTaskRepository();
    }

    @Test
    void should_multiple_words_as_name() {
        final AddCommand command = new AddCommand(taskRepository, "add", "fizz", "buzz");
        command.execute();

        assertEquals("fizz buzz", taskRepository.getTaskName());
    }
    @Test
    void should_use_empty_name_when_no_args_provided() {

        final AddCommand command = new AddCommand(taskRepository, "add");
        command.execute();

        assertEquals("", taskRepository.getTaskName());
    }

    private static class MyTaskRepository extends TaskRepository {
        private Task task;

        @Override
        List<String> createTask(Task task) {
            this.task = task;
            return List.of();
        }

        public String getTaskName() {
            return this.task.getName();
        }
    }
}