package com.tw.cn.cap.gtb.todo;

/**
 * @author zxh
 */
public class TaskMarshaller {
    TaskMarshaller() {

    }

    static Task unmarshal(String line, int id) {
        final String[] fields = line.split(" ", 2);
        final String name = fields[1];
        final boolean isCompleted = "x".equals(fields[0]);
        return new Task(id, name,isCompleted);
    }


    static String marshal(Task task) {
        return "+ " + task.getName();
    }
}