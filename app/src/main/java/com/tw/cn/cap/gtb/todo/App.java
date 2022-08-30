package com.tw.cn.cap.gtb.todo;
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
        if (args.length > 0 && ADD.equals(args[0])) {
            return new AddCommand().execute(args);
        }
        return new ListCommand().run();
    }
}
