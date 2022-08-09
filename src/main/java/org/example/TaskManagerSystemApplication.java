package org.example;

import enums.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerSystemApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerSystemApplication.class, args);
    }
    @Autowired
    private TaskManagerRepository taskManagerRepository;

    @Override
    public void run(String... strings) throws Exception {
        TaskManager process = new TaskManager( "first", Priority.low);
		  taskManagerRepository.save(process);

//        TaskManager process2 = new TaskManager("second",  Priority.medium);
//        taskManagerRepository.save(process2);
//
//
//        TaskManager process3 = new TaskManager("third",  Priority.high);
//        taskManagerRepository.save(process3);

    }
}