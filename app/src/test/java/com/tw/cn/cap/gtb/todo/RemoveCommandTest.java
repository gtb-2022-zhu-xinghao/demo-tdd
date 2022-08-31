package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RemoveCommandTest {
    @Test
    void should_remove_multiple_tasks() {

        TaskRepository repository = mock(TaskRepository.class);
        final RemoveCommand command = new RemoveCommand(repository, "1", "3");
        command.execute();
        verify(repository).deleteTask(1);
        verify(repository).deleteTask(3);
    }
}