package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        writeDateFile(List.of(
                "+ + task 01",
                "+ + task 02",
                "x + task 03",
                "x + task 04"));
        app = new App();
    }

    @Nested
    class ListCommand {
        @Nested
        class IfFileExistingTasks {
            @Test
            void should_list_existing_tasks() {
                final List<String> result = app.run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 task 01",
                        "2 task 02",
                        "# Completed",
                        "3 task 03",
                        "4 task 04"), result);
            }
        }
    }

    @Nested
    class AddCommand {
        @Nested
        class SupportSingleWordAsTaskName {
            @Test
            void should_add_task_with_single_word_as_name() {
                app.run( "add","foobar");
                final List<String> result = app.run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 task 01",
                        "2 task 02",
                        "5 foobar",
                        "# Completed",
                        "3 task 03",
                        "4 task 04"), result);
            }
            @Test
            void should_add_task_with_multiple_word_as_name() {
                app.run("add","foobar","fizz");
                final List<String> result = new App().run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "1 task 01",
                        "2 task 02",
                        "5 foobar fizz",
                        "# Completed",
                        "3 task 03",
                        "4 task 04"), result);
            }
        }
    }
    @Nested
    class RemoveCommand {

        @Nested
        class WhenRemoveSingleTask {
            @Test
            void should_remove_single_id () {
                app.run( "remove","1");
                final List<String> result = app.run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 task 02",
                        "# Completed",
                        "3 task 03",
                        "4 task 04"), result);
            }
        }
        @Nested
        class whenRemoveMultipleTask {
            @Test
            void should_remove_multiple_task () {
                app.run( "remove","1","3");
                final List<String> result = app.run();
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 task 02",
                        "# Completed",
                        "4 task 04"), result);
            }
        }
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
