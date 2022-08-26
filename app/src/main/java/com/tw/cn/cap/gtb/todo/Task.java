package com.tw.cn.cap.gtb.todo;

/**
 * @author zxh
 */
public class Task {
    private long id;
    private String name;

    public Task(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }
}
