package org.example.Repository;

import enums.Priority;
import org.example.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
 public interface TaskManagerRepository extends JpaRepository<TaskManager, Long> {

}