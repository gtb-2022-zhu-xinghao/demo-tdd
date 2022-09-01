package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;

/**
 * @author zxh
 */
public class CommandFactory {
    private CommandFactory() {
    }

    static Command createCommand(TaskRepository repository, String[] args) {
        final String[] restArgs = Arrays.copyOfRange(args, 1, args.length);
        final String commandName = args[0];

        Command command = new ListCommand(repository);
        if (Constant.ADD.equals(commandName)) {
            command = new AddCommand(repository, restArgs);
        }
        if (Constant.REMOVE.equals(commandName)) {
            command = new RemoveCommand(repository, restArgs);
        }
        return command;
    }
}