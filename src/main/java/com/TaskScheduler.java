package com;

public class TaskScheduler {
    private TaskQueue taskQueue;

    public TaskScheduler(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    public void submitTask(Task task){
        taskQueue.addTask(task);
    }
}
