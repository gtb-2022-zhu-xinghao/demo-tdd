package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;

/**
 * @author zxh
 */
public class RemoveCommand {
    private final TaskRepository taskRepository;
    private final String[] restArgs;

    public RemoveCommand(TaskRepository taskRepository, String... restArgs) {
        this.taskRepository = taskRepository;
        this.restArgs = restArgs;
    }

    public List<String> execute() {
        Arrays.stream(restArgs)
                .map(Integer::valueOf)
                .forEach(this.taskRepository::deleteTask);
        return List.of();
    }

}
