package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 */
public class App {

    private final TaskRepository taskRepository = new TaskRepository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        final List<String> result = new ArrayList<>();
        result.add("# To be done");
        final List<Task> tasks = taskRepository.loadTasks();
        for(var task: tasks){
            result.add(task.format());
        }
        return result;
    }
}
