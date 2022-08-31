package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TaskMarshallerTest {


    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_marshal_to_plain_text(String line, Task task) {
        assertEquals(line, TaskMarshaller.marshal(task));
    }
    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_unmarshal_from_to_text(String line, Task task) {
        assertEquals(task, TaskMarshaller.unmarshal(line, 0));
    }
    public static Stream<Arguments> lines_and_tasks() {
        return Stream.of(
                Arguments.of("+ foo",new Task(0,"foo",false,false)),
                Arguments.of("x foo",new Task(0,"foo",true,false)),
                Arguments.of("+    foo bar     ",new Task(0,"   foo bar     ",false,false))
        );
    }
}