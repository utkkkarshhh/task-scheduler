package com.springboot.service;

import org.springframework.stereotype.Component;
import com.springboot.entity.Task;

@Component
public class TaskScheduler {
    private TaskQueue taskQueue;

    public TaskScheduler(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    public void submitTask(Task task) {
        taskQueue.addTask(task);
    }
}
