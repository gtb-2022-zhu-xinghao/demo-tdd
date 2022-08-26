package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 */
public class TaskRepository {
    List<Task> loadTasks() {
        final List<Task> tasks = new ArrayList<Task>();
        final List<String> lines = readTasksLines();
        for (int i = 0; i < lines.size(); i++) {
            final Task task = createTask(lines, i);
            tasks.add(task);
        }
        return tasks;
    }

    Task createTask(List<String> lines, int i) {
        final int id = i + 1;
        final String[] fields = lines.get(i).split(" ", 2);
        final String name = fields[1];
        final Task task = new Task(id, name);
        return task;
    }

    List<String> readTasksLines() {
        try {
            return Files.readAllLines(Constant.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}