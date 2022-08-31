package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Nested
    class equals {
        @Nested
        class should_return_true {
            @Test
            void when_properties_are_same() {
                assertEquals(new Task(1, "foobar", false,false), new Task(1, "foobar", false,false));
                assertEquals(new Task(1, "foobar", true,true), new Task(1, "foobar", true,true));
            }
        }
        @Nested
        class should_return_false {
            @Test
            void when_at_least_one_property_is_different() {
                assertNotEquals(new Task(1, "foobar", false,false), new Task(2, "foobar", false,false));
                assertNotEquals(new Task(1, "foobar", false,false), new Task(1, "foo", false,false));
                assertNotEquals(new Task(1, "foobar", true,false), new Task(1, "foobar", false,false));
                assertNotEquals(new Task(1, "foobar", true,false), new Task(1, "foobar", false,false));
            }
        }
    }

}