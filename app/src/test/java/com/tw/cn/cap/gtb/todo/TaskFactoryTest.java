package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTest {
    @Test
    void should_parse_completed_tasks() {
        final boolean isCompleted = TaskFactory.createTask("+ foo", 1).isCompleted();
        assertFalse(isCompleted);
    }
}