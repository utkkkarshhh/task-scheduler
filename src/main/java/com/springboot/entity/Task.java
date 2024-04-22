    package com.springboot.entity;

    public class Task implements Comparable<Task>  {
        private String id;
        private int priority;
        private String status;
        private Runnable executionInstructions;

        public Task(String id, int priority, String status, Runnable executionInstructions) {
            this.id = id;
            this.priority = priority;
            this.status = status;
            this.executionInstructions = executionInstructions;
            
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setExecutionInstructions(Runnable executionInstructions) {
            this.executionInstructions = executionInstructions;
        }

        public Runnable getExecutionInstructions(){
            return executionInstructions;
        }
    }
