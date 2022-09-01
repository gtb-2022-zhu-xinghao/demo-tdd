package com.tw.cn.cap.gtb.todo;

import java.util.List;

/**
 * @author zxh
 */
public abstract class Command {
    final TaskRepository taskRepository;

    Command(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    abstract List<String> execute();
}
