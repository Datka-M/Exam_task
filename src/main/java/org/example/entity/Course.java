package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor

public class Course implements Comparable<Course>{

    @Id
    @GeneratedValue(generator = "course_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",sequenceName = "course_seq",allocationSize = 1)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private int duration;
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "image_link")
    private String imageLink;
    private String description;

    public Course(String courseName, int duration, LocalDate createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;
    }

    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH},
            mappedBy = "courses",
            fetch = FetchType.EAGER)
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "course",
            cascade = {CascadeType.ALL})
    private List<Lesson> lessons;


    @Override
    public String toString() {
        return "Course:" +
                " id = " + id +
                ", courseName= '" + courseName + '\'' +
                ", duration = " + duration +
                ",\n createAt = " + createAt +
                ", imageLink = '" + imageLink + '\'' +
                ", description = '" + description+"\n";
    }



    public void addInstructor(Instructor instructor1){
        instructors.add(instructor1);
    }



    @Override
    public int compareTo(Course course) {
        return createAt.compareTo(course.createAt);
    }
}
