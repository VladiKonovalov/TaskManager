package org.example;
import enums.Priority;

public class Process {

 private long id;
    private Priority priority;
    public Process() {

    }
    public Process(Long id, String priority) {
        this.id = id;
        this.priority = getPriority(priority);
    }
    public long getId(){
        return id;
    }
    public Priority getPriority(){
        return priority;}

    private Priority getPriority(String priority) {
        switch (priority.toLowerCase()) {
            case "high" -> {
                return this.priority.high;
            }
            case "medium" -> {
                return this.priority.medium;
            }
            case "low" -> {
                return this.priority.low;
            }


        }

        return null;
    }

}
