package com.springboot.service;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.springboot.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskQueue {
    private PriorityQueue<Task> queue;
    private Lock lock; 

    public TaskQueue(){
        this.queue = new PriorityQueue<>();
        this.lock = new ReentrantLock();
    }

    public void addTask(Task task){
        lock.lock();
        try{
            queue.add(task);
        }finally{
            lock.unlock();
        }
    }

    public Task removeTask(){
        lock.lock();
        try{
            return queue.poll();
        }finally{
            lock.unlock();
        }

    }

    public int size(){
        lock.lock();
        try{
            return queue.size();
        } finally{
            lock.unlock();
        }
    }
}
