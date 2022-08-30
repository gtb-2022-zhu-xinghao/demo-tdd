package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zxh
 */
public class AddCommand {
    final TaskRepository taskRepository = new TaskRepository();
    private final String[] args;

    public AddCommand(String[] args) {
        this.args = args;
    }

    List<String> execute() {
        final String name = Arrays.stream(args).skip(1).collect(Collectors.joining(" "));
        return taskRepository.createTask(new Task(0, name, false));
    }
}