package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTest {
    @Test
    void should_parse_completed_tasks() {
        final boolean isCompleted = TaskFactory.createTask("+ foo", 1).isCompleted();
        assertFalse(isCompleted);
    }
    @Test
    void should_support_name_with_multiple_white_spaces() {
        final String result = TaskFactory.createTask("+    foo bar     ", 1).getName();
        assertEquals("   foo bar     ", result);
    }
}