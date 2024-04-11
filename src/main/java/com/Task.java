package com;

import java.util.*;

public class Task implements Comparable<Task> {
    private int id;
    private int priority;
    private List<Task> dependencies;
    private Runnable executionInstructions;

    public Task(int id, int priority, Runnable executionInstructions){
        this.id = id;
        this.priority = priority;
        this.executionInstructions = executionInstructions;
        this.dependencies = new ArrayList<>();
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    //Getter and setter methods for task
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

   public List<Task> getDependencies(){
    return dependencies;
   }

   public void setDependencies(List <Task> dependencies){
    this.dependencies = dependencies;
   }

   public Runnable getExecutionInstructions(){
    return executionInstructions;
   }

   public void setDependencies(Runnable executionInstructions){
    this.executionInstructions = executionInstructions;
   }

    //Method to add dependency management
    public void addDependency(Task task){
        dependencies.add(task);
    }

    //  Method to remove dependency
    public void removeDependency(Task task){
        dependencies.remove(task);
    }


    // Other methods as needed
}
