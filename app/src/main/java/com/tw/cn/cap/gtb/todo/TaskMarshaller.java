package com.tw.cn.cap.gtb.todo;

/**
 * @author zxh
 */
public class TaskMarshaller {
    private TaskMarshaller() {
    }
    static String marshal(Task task) {
        return "+ " + task.getName();
    }

   static Task unmarshal(String line, int id) {
        final String[] fields = line.split(" ", 2);
        final String name = fields[1];
        final boolean isCompleted = fields[0].equals("x");
        return new Task(id, name,isCompleted);
    }


}