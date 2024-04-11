package com;

import java.lang.Thread;

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
                    // If no task available, sleep for a short duration to avoid busy waiting
                    Thread.sleep(100); // Sleep for 100 milliseconds
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
