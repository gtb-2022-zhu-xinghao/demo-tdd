package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;

/**
 * @author zxh
 */
public class AddCommand {
    final TaskRepository taskRepository;

    private final String[] args;

    public AddCommand(TaskRepository taskRepository, String... args) {
        this.args = args;
        this.taskRepository = taskRepository;
    }

    List<String> execute() {
        final String name = String.join(" ",Arrays.copyOfRange(args, 1, args.length));
        return taskRepository.createTask(new Task(0, name, false));
    }
}