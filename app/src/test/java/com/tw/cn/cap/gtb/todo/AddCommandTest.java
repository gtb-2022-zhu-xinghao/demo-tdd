package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddCommandTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    void should_multiple_words_as_name() {
        final AddCommand command = createCommandFrom( "fizz", "buzz");
        command.execute();
        verify(taskRepository).createTask(new Task(0,"fizz buzz",false));
    }
    @Test
    void should_use_empty_name_when_no_args_provided() {

        final AddCommand command = createCommandFrom("");
        command.execute();
        verify(taskRepository).createTask(new Task(0,"",false));
    }

    private AddCommand createCommandFrom(String... args) {
        final AddCommand command = new AddCommand(taskRepository, args);
        return command;
    }

}