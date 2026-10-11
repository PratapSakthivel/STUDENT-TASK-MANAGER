package student_task_manager.service;


import java.util.*;
import org.springframework.stereotype.Service;
import student_task_manager.model.Task;
import student_task_manager.model.TaskStatus;
import student_task_manager.repository.TaskRepository;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow();
    }


    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDeadline(updatedTask.getDeadline());
        existingTask.setStatus(updatedTask.getStatus());

        return taskRepository.save(existingTask);
    }

    public void  deleteTaskById (Long id){
         taskRepository.deleteById(id);
    }

    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task task = getTaskById(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }

}
