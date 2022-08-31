package com.tw.cn.cap.gtb.todo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zxh
 */
public class TaskRepository {
    List<Task> loadTasks() {
        final List<Task> tasks = loadAllTasks();
        return tasks.stream().filter(task -> !task.isDeleted()).collect(Collectors.toList());
    }

    private List<Task> loadAllTasks() {
        final List<Task> tasks = new ArrayList<>();
        final List<String> lines = readTasksLines();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(TaskMarshaller.unmarshal(lines.get(i), i + 1));
        }
        return tasks;
    }

    List<String> createTask(Task task) {
        try (final BufferedWriter bw = Files.newBufferedWriter(Constant.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            bw.write(TaskMarshaller.marshal(task));
            bw.newLine();
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
        return List.of();
    }

    void deleteTask(int id) {
        final List<Task> tasks = loadAllTasks();
        tasks.stream().filter(task -> id == task.getId()).forEach(Task::delete);
        try (final BufferedWriter bw = Files.newBufferedWriter(Constant.TASKS_FILE_PATH)) {
            for (var task : tasks) {
                bw.write(TaskMarshaller.marshal(task));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }

    List<String> readTasksLines() {
        try {
            return Files.readAllLines(Constant.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }

}