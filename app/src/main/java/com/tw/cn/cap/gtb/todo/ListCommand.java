package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 */
public class ListCommand extends Command {

    public ListCommand(TaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    List<String> execute() {
        final List<Task> tasks = taskRepository.all();
        final List<String> result = new ArrayList<>();
        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));
        return result;
    }
}