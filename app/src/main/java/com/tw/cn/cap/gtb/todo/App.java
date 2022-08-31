package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;

/**
 * @author zxh
 */
public class App {


    public static final String ADD = "add";

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {

        if (args.length <= 0) {
            return new ListCommand().run();
        }
        if (ADD.equals(args[0])) {
            final String[] restArgs = Arrays.copyOfRange(args, 1, args.length);
            return new AddCommand(new TaskRepository(), restArgs).execute();
        }
        if ("remove".equals(args[0])) {
            final String[] restArgs = Arrays.copyOfRange(args, 1, args.length);
            return new RemoveCommand(new TaskRepository(), restArgs).execute();
        }
        return new ListCommand().run();
    }
}
