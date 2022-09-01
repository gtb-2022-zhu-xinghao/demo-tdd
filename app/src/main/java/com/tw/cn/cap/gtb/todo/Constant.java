package com.tw.cn.cap.gtb.todo;

import java.nio.file.Path;

/**
 * @author zxh
 */
public class Constant {
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String LIST = "list";

    private Constant() {
    }

    public static final String USER_HOME_ROOT = System.getProperty("user.home");
    public static final String TODO_CONFIG_ROOT = ".todo";
    public static final String TASKS_ROOT = "tasks";
    public static final Path TASKS_FILE_PATH = Path.of(USER_HOME_ROOT, TODO_CONFIG_ROOT, TASKS_ROOT);
}