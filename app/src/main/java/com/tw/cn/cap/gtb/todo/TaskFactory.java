package com.tw.cn.cap.gtb.todo;

/**
 * @author zxh
 */
public class TaskFactory {
    private TaskFactory() {
    }

   public static Task createTask(String line, int id) {
        final String[] fields = line.split(" ", 2);
        final String name = fields[1];
        final boolean isCompleted = fields[0].equals("x");
        return new Task(id, name,isCompleted);
    }


}