package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        final List<Integer> ids = Arrays.stream(restArgs)
                .map(Integer::valueOf).toList();
        taskRepository.all().stream()
                .filter(task -> ids.contains(task.getId()))
                .forEach(task -> taskRepository.deleteTask(task.getId()));
        return List.of();
    }

}
