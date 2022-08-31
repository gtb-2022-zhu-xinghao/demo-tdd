package com.tw.cn.cap.gtb.todo;

import java.util.Objects;

/**
 * @author zxh
 */
public class Task {
    private final long id;
    private final String name;
    private final boolean isCompleted;
    private final boolean deleted;


    public Task(long id, String name, boolean isCompleted, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
        this.deleted = isDeleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    String format() {
        return String.format("%d %s", getId(), getName());
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCompleted=" + isCompleted +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return id == task.id && isCompleted == task.isCompleted && deleted == task.deleted && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCompleted, deleted);
    }

    public boolean isDeleted() {
        return this.deleted;
    }
}
