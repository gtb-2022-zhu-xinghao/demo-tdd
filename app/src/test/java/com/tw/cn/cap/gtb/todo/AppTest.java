package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void should_list_existing_tasks() {
        final List<String> result = new App().run();
        Assertions.assertEquals(
                List.of(
                        "# To be done",
                        "1 task 01",
                        "2 task 02"), result);
    }
}
