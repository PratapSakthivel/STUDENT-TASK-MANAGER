package student_task_manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import student_task_manager.model.Task;
import student_task_manager.repository.TaskRepository;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import student_task_manager.model.Task;
import org.junit.jupiter.api.Test;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TaskRepositoryTest {

    @Autowired
    public TaskRepository taskRepository;


    @Test
    void shouldSaveTaskAndGenerateId() {
        Task task = new Task();
        task.setTitle("Learn Spring Data JPA");
        task.setDescription("Practice repository operations");

        Task savedTask = taskRepository.save(task);

        assertNotNull(savedTask.getId());
    }


    @Test
    void shouldFindAllTasks() {
        Task task = new Task();
        task.setTitle("Learn JPA");
        task.setDescription("Practice findAll");

        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();

        assertFalse(tasks.isEmpty());
        assertTrue(tasks.stream()
                .anyMatch(saved -> saved.getTitle().equals("Learn JPA")));
    }


    @Test
    void shouldFindTaskById() {
        Task task = new Task();
        task.setTitle("Learn SQL");
        task.setDescription("Practice findById");

        Task savedTask = taskRepository.save(task);

        Optional<Task> result =
                taskRepository.findById(savedTask.getId());

        assertTrue(result.isPresent());
        assertEquals("Learn SQL", result.get().getTitle());
    }


    @Test
    void shouldReturnEmptyWhenTaskIdDoesNotExist() {
        Optional<Task> result = taskRepository.findById(-1L);

        assertTrue(result.isEmpty());
    }


    @Test
    void shouldDeleteTaskById() {
        Task task = new Task();
        task.setTitle("Delete this task");
        task.setDescription("Practice deleteById");

        Task savedTask = taskRepository.save(task);
        Long taskId = savedTask.getId();

        taskRepository.deleteById(taskId);

        Optional<Task> result = taskRepository.findById(taskId);

        assertTrue(result.isEmpty());
    }

}
