package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {
    @Test
    void should_delete_multiple_tasks() {
        final TaskRepository taskRepository = new TaskRepository();

        taskRepository.deleteTask(1);
        taskRepository.deleteTask(3);

        final List<Task> result = taskRepository.loadTasks();
        assertEquals(List.of(
                new Task(2, "task 02", false, false),
                new Task(4, "task 04", true, false)
                ), result);
    }
}