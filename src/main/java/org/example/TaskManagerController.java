package org.example;

import enums.Priority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TaskManagerController {
    int MaxOpenProcesses = 5;
    private TaskManagerService taskManagerService;

    public TaskManagerController(TaskManagerService taskManagerService) {
        super();
        this.taskManagerService = taskManagerService;
    }

    //  method to handle list of tasks
    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("maxOpenProcess", MaxOpenProcesses);
        model.addAttribute("tasks", taskManagerService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String createProcessForm(Model model) {

        // create task object
        TaskManager task = new TaskManager();
        model.addAttribute("task", task);
        return "new_process";

    }

    //  @RequestMapping(value={"/approach"},method = RequestMethod.POST)
    @PostMapping(path = "/tasks/approach/{approach}")
    public String saveProcess(@ModelAttribute("task") TaskManager task, String approach) {
        int CorrentlyWorkingProcess = taskManagerService.getAllTasks().size();
        if (CorrentlyWorkingProcess < MaxOpenProcesses) {
            taskManagerService.newProcess(task);

        } else if (approach.equals("naive")) {
            System.out.println("Corrently Working Process: " + CorrentlyWorkingProcess);
            System.out.println("Max Working Process: " + MaxOpenProcesses);
            System.out.println(approach);
        }
    else if (approach.equals("fifo")) {
            taskManagerService.killTheOldestProcess();
            taskManagerService.newProcess(task);
        } else {
           Priority newTaskPriority= task.getPriority();
         if(  taskManagerService.killLessImportant(newTaskPriority))
             taskManagerService.newProcess(task);;
        }
        return "redirect:/tasks";
    }

    // handler method to handle delete student request

    @GetMapping("/tasks/{id}")
    public String killProcess(@PathVariable Long id) {
        taskManagerService.killProcess(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/priority/{priority}")
//    public void killGroupProcess(@PathVariable (value="priority" ) Priority priority) {
    public String killGroupProcess(@PathVariable(value = "priority") Priority priority) {
        taskManagerService.killGroup(priority);
        return "redirect:/tasks";
        //    taskManagerService.killGroup(priority);
        //   return "redirect:/tasks";
    }

    @GetMapping("/tasks/deleteAll")
    public String killAllProcess() {
        taskManagerService.killAllProcesses();
        return "redirect:/tasks";
    }
}
