package com.tw.cn.cap.gtb.todo;

import java.util.List;

/**
 * @author zxh
 */
public class AddCommand {
    final TaskRepository taskRepository = new TaskRepository();
    List<String> execute(String[] args) {
        final Task task = new Task(0, args[1], false);
        return taskRepository.createTask(task);
    }
}