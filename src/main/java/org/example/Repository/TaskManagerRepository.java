package org.example.Repository;

import enums.Priority;
import org.example.TaskManager;
import org.example.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

// public interface TaskManagerRepository extends JpaRepository<TaskManager, Long> {
 public interface TaskManagerRepository extends MongoRepository<TaskManager, Long> {
}