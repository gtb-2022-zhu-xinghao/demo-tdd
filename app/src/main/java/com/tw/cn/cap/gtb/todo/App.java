package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zxh
 */
public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        final List<String> result = new ArrayList<>();
        result.add("# To be done");
        final List<String> lines = readTasksLines();
        for (int i = 0; i < lines.size(); i++) {
            final int id = i + 1;
            final String[] fields = lines.get(i).split(" ", 2);
            final String name = fields[1];
            result.add(String.format("%d %s", id, name));
        }
        return result;
    }

    private List<String> readTasksLines() {
        try {
            return Files.readAllLines(Constant.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
