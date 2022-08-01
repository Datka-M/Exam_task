package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@NoArgsConstructor
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(generator = "instructor_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor_gen", sequenceName = "instructor_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true, nullable = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Instructor(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Course> courses ;

    public void addCourse(Course course1){
        courses.add(course1);
    }


    @Override
    public String toString() {
        return "Instructor:" +
                " id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", \nlastName = '" + lastName + '\'' +
                ", email = '" + email + '\'' +
                ", phoneNumber = '" + phoneNumber+"\n";
    }
}
