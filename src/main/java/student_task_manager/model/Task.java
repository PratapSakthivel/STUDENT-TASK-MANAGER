package student_task_manager.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String title;
    String description;
    LocalDateTime deadline;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

}
