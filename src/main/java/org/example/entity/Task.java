package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(generator = "task_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_gen",sequenceName = "task_seq",allocationSize = 1)
    private Long id;
    @Column(name = "dead_line")
    private LocalDate deadLine;
    private String task;


    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;

    public Task(LocalDate deadLine, String task) {
        this.deadLine = deadLine;
        this.task = task;

    }

    @Override
    public String toString() {
        return "Task:" +
                "id = " + id +
                ", deadLine = " + deadLine +
                ", task = '" + task+"\n";
    }
}
