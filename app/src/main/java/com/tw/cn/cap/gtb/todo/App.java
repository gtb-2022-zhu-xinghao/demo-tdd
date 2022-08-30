package com.tw.cn.cap.gtb.todo;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author zxh
 */
public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length > 0 && args[0].equals("add")) {
            return execute(args);
        }
        return listCommand.run();
    }

    private List<String> execute(String[] args) {
        try (final BufferedWriter bw = Files.newBufferedWriter(Constant.TASKS_FILE_PATH, StandardOpenOption.APPEND);) {
            final String taskName = args[1];
            bw.write("+ " + taskName);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
        return List.of();
    }
}
