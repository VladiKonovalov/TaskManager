package org.example;

import enums.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class TaskManagerService {
    @Autowired
    private TaskManagerRepository repo;

    public List<TaskManager> getAllTasks() {
        return repo.findAll();
    }

    public void newProcess(TaskManager process) {

        repo.save(process);
    }

    public TaskManager getProcess(long id) {
        return repo.findById(id).get();
    }

    public void killProcess(long id) {
        repo.deleteById(id);
    }

  //  private JdbcTemplate jdbcTemplate;
  public boolean killLessImportant(Priority priority) {
      List<TaskManager> list = repo.findAll();
      List<TaskManager> meduimlist = new ArrayList<TaskManager>();
      List<TaskManager> lowlist = new ArrayList<TaskManager>();
      Iterator itr = list.iterator();
      while (itr.hasNext()) {
          TaskManager element = (TaskManager) itr.next();
          if (Priority.isMoreImportant(priority, element.getPriority())) {
              if (element.getPriority().equals(Priority.low))
                  lowlist.add(element);
              else if (element.getPriority().equals(Priority.medium)) {
                  meduimlist.add(element);
              }
          }
          if (lowlist.size() > 0) {
              repo.deleteById(lowlist.stream().findFirst().get().getId());
              return true;
          } else if (meduimlist.size() > 0) {
              repo.deleteById(meduimlist.stream().findFirst().get().getId());
              return true;
          }

      }
      return false;

  }
  public void  killTheOldestProcess(){
      List<TaskManager>  list=repo.findAll();
      repo.deleteById(list.stream().findFirst().get().getId());
  }
    public void killGroup(Priority priority) {
        List<TaskManager>  list=repo.findAll();
        Iterator itr = list.iterator();
        while(itr.hasNext()) {
            TaskManager element= (TaskManager) itr.next();
if (element.getPriority().equals(priority))
    repo.deleteById(element.getId());
        }

      //      int numberOfRowsAffected=jdbcTemplate.update(sql,priority);
    }
////

//    @Query(value="DELETE FROM TASKS WHERE PRIORITY=2",
//    countQuery="SELECT COUNT(*) FROM TASKS WHERE PRIORITY=2",nativeQuery = true)
//    public List<TaskManager> killGroup(Priority priority) {
//   return repo.findAll(priority);
//    }

    public void killAllProcesses() {
        repo.deleteAll();
    }

}
