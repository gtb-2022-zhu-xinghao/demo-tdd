package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class RemoveCommandTest {

    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(TaskRepository.class);
        when(repository.all()).thenReturn(List.of(
                new Task(1,"task 01",false,false),
                new Task(2,"task 02",false,false),
                new Task(3,"task 03",false,false),
                new Task(4,"task 04",false,false)
        ));
    }

    @Test
    void should_remove_multiple_tasks() {

        final RemoveCommand command = new RemoveCommand(repository, "1", "3");

        command.execute();

        verify(repository).deleteTask(1);
        verify(repository).deleteTask(3);
    }

    @Test
    void should_remove_existing_tasks() {

        final RemoveCommand command = new RemoveCommand(repository, "1", "3","404");

        command.execute();

        verify(repository).deleteTask(1);
        verify(repository).deleteTask(3);
        verify(repository,never()).deleteTask(404);
    }
}