package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(generator = "lesson_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lesson_gen",sequenceName = "lesson_seq",allocationSize = 1)
    private Long id;
    private String name;
    @Column(name = "video_link")
    private String videoLink;

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

    @OneToMany(mappedBy = "lesson",
            cascade = {CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.REMOVE},
            fetch = FetchType.EAGER)
    private List<Task> tasks;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Course course;

    public void setTasks(Task task){
        if (tasks==null){
            tasks= new ArrayList<>();
        }
        tasks.add(task);
    }

    @Override
    public String toString() {
        return "Lesson: " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", videoLink = '" + videoLink+"\n";
    }
}
