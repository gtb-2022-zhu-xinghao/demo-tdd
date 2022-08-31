package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskMarshallerTest {

    TaskMarshaller taskMarshaller;

    @BeforeEach
    void setUp() {
        taskMarshaller = new TaskMarshaller();
    }

    @Test
    void should_parse_completed_tasks() {
        final boolean isCompleted = taskMarshaller.unmarshal("+ foo", 1).isCompleted();
        assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        final String result = taskMarshaller.unmarshal("+    foo bar     ", 1).getName();
        assertEquals("   foo bar     ", result);
    }
}