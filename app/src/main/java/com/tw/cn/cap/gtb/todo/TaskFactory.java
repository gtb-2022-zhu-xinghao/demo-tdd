package com.tw.cn.cap.gtb.todo;

/**
 * @author zxh
 */
public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(String line, int id) {
        final String[] fields = line.split(" ", 2);
        final String name = fields[1];
        return new Task(id, name);
    }
}