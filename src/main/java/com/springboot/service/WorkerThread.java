package com.springboot.service;

import com.springboot.entity.Task;

public class WorkerThread extends Thread {
    private TaskQueue taskQueue;

    // Worker Thread Constructor
    public WorkerThread(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = taskQueue.removeTask();
                if (task != null) {
                    task.getExecutionInstructions().run();
                } else {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
