package com.tw.cn.cap.gtb.todo;

/**
 * @author zxh
 */
public class TaskMarshaller {
    TaskMarshaller() {

    }

    static Task unmarshal(String line, int id) {
        final String[] fields = line.split(" ", 3);
        final String name = fields[2];
        final boolean isCompleted = "x".equals(fields[0]);
        final boolean deleteSign = "x".equals(fields[1]);
        return new Task(id, name,isCompleted,deleteSign);
    }


    static String marshal(Task task) {
        final String completedSign = task.isCompleted() ? "x" : "+";
        final String deleteSign = task.isDeleted() ? "x" : "+";

        return completedSign + " " +  deleteSign + " " + task.getName();
    }
}