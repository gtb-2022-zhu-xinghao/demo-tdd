package com.tw.cn.cap.gtb.todo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 */
public class TaskRepository {
    private final TaskMarshaller taskMarshaller = new TaskMarshaller();

    List<Task> loadTasks() {
        final List<Task> tasks = new ArrayList<>();
        final List<String> lines = readTasksLines();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(taskMarshaller.unmarshal(lines.get(i), i + 1));
        }
        return tasks;
    }

    List<String> createTask(Task task) {
        try (final BufferedWriter bw = Files.newBufferedWriter(Constant.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            final String line = taskMarshaller.marshal(task);
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
        return List.of();
    }

    List<String> readTasksLines() {
        try {
            return Files.readAllLines(Constant.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}