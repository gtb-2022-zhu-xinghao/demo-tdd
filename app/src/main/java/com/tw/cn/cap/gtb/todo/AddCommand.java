package com.tw.cn.cap.gtb.todo;

import java.util.List;

/**
 * @author zxh
 */
public class AddCommand extends Command {

    private final String[] args;

    public AddCommand(TaskRepository taskRepository, String... args) {
        super(taskRepository);
        this.args = args;
    }

    List<String> execute() {
        final String name = String.join(" ",args);
        taskRepository.createTask(new Task(0, name, false, false));
        return List.of();
    }
}