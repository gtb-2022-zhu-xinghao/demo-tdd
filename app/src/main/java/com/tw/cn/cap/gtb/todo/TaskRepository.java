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
    List<Task> loadTasks() {
        final List<Task> tasks = new ArrayList<>();
        final List<String> lines = readTasksLines();
        for (int i = 0; i < lines.size(); i++) {
            final int id = i + 1;
            final String line = lines.get(i);
            final Task task = TaskFactory.createTask(line, id);
            tasks.add(task);
        }
        return tasks;
    }
    List<String> createTask(Task task) {
        final String taskName = task.getName();
        try (final BufferedWriter bw = Files.newBufferedWriter(Constant.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            bw.write("+ " + taskName);
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