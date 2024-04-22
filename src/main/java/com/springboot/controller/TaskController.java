package com.springboot.controller;

import com.springboot.entity.Task;
import com.springboot.service.TaskQueue;
import com.springboot.service.TaskScheduler;
import com.springboot.service.WorkerThread;
import com.springboot.service.TaskMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TaskController {

    @Autowired
    private TaskQueue taskQueue;

    @Autowired
    private TaskScheduler scheduler;

    @PostMapping("/getTasks")
    public void receiveTasks(@RequestBody Task[] tasks) {
        for (Task task : tasks) {
            System.out.println("Task ID: " + task.getId() + " | Task Priority: " + task.getPriority() + " | Task Status: " + task.getStatus() + " | Execution Instructions: " + task.getExecutionInstructions());

            Task newTask = new Task(task.getId(), task.getPriority(), task.getStatus(), () -> {
                System.out.println("Executing Task: Priority - " + task.getPriority() + " | Task ID - " + task.getId());
            });

            scheduler.submitTask(newTask);
        }

        TaskMonitor taskMonitor = new TaskMonitor(taskQueue);

        // Task queue size in the beginning 
        System.out.println("Initial queue size: " + taskMonitor.getQueueSize());

        // Create and start worker threads
        int numThreads = 3; // Number of worker threads
        WorkerThread[] threads = new WorkerThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new WorkerThread(taskQueue);
            threads[i].start(); // Start the thread
        }

        // Wait for some time to observe task execution
        try {
            Thread.sleep(5000); // Sleep for 5 seconds initially 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        // Task queue size in the end
        System.out.println("Final queue size: " + taskMonitor.getQueueSize());
    }

    // Endpoint for testing
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
}
