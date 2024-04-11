package com;

import java.util.*;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue(); //Task Queue Made

        TaskScheduler taskScheduler = new TaskScheduler(taskQueue); //Scheduler created for the queue

        // Create worker threads
        int numThreads = 4; // Number of worker threads
        WorkerThread[] threads = new WorkerThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new WorkerThread(taskQueue);
            threads[i].start(); // Start the thread
        }

        // Create and submit 100 tasks with random priorities
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int taskId = i + 1;
            int priority = random.nextInt(10); // Generate a random priority between 0 and 9
            Task task = new Task(taskId, priority, () -> System.out.println("Executing Task: Priority - " + priority + " | Task ID - " + taskId));
            taskScheduler.submitTask(task);
        }

        TaskMonitor taskMonitor = new TaskMonitor(taskQueue);

        // Task queue size in the beginning 
        System.out.println("Initial queue size: " + taskMonitor.getQueueSize());

        // Wait for some time to observe task execution
        try {
            Thread.sleep(5000); // Sleep for 5 seconds Inititally 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Task queue size in the end
        System.out.println("Final queue size: " + taskMonitor.getQueueSize());
    }
}
