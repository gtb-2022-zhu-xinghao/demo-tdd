package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 */
public record Section(String title, boolean flag) {

    static Section completed() {
        return new Section("# Completed", true);
    }

    static Section tbd() {
        return new Section("# To be done", false);
    }

    List<String> format(List<Task> tasks) {
        final List<String> result = new ArrayList<>();
        result.add(title());
        tasks.stream()
                .filter(this::isType)
                .map(Task::format)
                .forEachOrdered(result::add);
        if (result.size() == 1){
            result.add("Empty");
        }
        return result;
    }

    private boolean isType(Task task) {
        return flag() == task.isCompleted();
    }

}