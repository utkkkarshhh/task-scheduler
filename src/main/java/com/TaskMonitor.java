package com;

public class TaskMonitor {
    private TaskQueue taskQueue;

    public TaskMonitor(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    public int getQueueSize(){
        return taskQueue.size();
    }
}
