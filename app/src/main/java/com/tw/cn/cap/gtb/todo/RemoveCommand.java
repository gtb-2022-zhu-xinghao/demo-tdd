package com.tw.cn.cap.gtb.todo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
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
        final List<Task> tasks = taskRepository.loadTasks();
        final String id = restArgs[0];
        tasks.stream().filter(task -> Integer.parseInt(id) == task.getId()).forEach(Task::delete);
        try (final BufferedWriter bw = Files.newBufferedWriter(Constant.TASKS_FILE_PATH)) {
            for (var task:tasks){
                bw.write(TaskMarshaller.marshal(task));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
        return List.of();
    }
}
