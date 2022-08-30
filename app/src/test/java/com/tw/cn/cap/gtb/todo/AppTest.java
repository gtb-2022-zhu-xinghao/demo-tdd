package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class AppTest {

    @BeforeEach
    void setUp() {
        writeDateFile(List.of(
                "+ task 01",
                "+ task 02",
                "x task 03",
                "x task 04"));
    }


    @Test
    void should_list_existing_tasks() {
        final List<String> result = new App().run();
        Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 task 01",
                        "2 task 02",
                        "# Completed",
                        "3 task 03",
                        "4 task 04"), result);
    }
    @Test
    void should_add_task_with_single_word_as_name() {
        new App().run("add","foobar");
        final List<String> result = new App().run();
        Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 task 01",
                        "2 task 02",
                        "5 foobar",
                        "# Completed",
                        "3 task 03",
                        "4 task 04"), result);
    }

    private void writeDateFile(List<String> lines) {
        try (BufferedWriter bw = Files.newBufferedWriter(Constant.TASKS_FILE_PATH)) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
