package org.example;


import org.example.config.Config;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;

import org.example.service.CourseService;
import org.example.service.InstructorService;
import org.example.service.LessonService;
import org.example.service.TaskService;
import org.example.service.serviceImpl.CourseServiceImpl;
import org.example.service.serviceImpl.InstructorServiceImpl;
import org.example.service.serviceImpl.LessonServiceImpl;
import org.example.service.serviceImpl.TaskServiceImpl;


import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Scanner;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        /**
         * Я перепроверила все методы по несколько раз,
         * в  момент  проверки и отправки проекта,
         * все методы работают ХОРОШО ,
         * надеюсь в момент проверки вами,
         * все методы будут работать :)
         */



        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService taskService = new TaskServiceImpl();


        Task task7 = new Task((LocalDate.of(2022, 8, 1)), "Task");
        Task task1 = new Task((LocalDate.of(2022, 4, 12)), "Azamat oinogonu ketti");
        Task task2 = new Task((LocalDate.of(2022, 5, 23)), "Zapolnite list");
        Task task3 = new Task((LocalDate.of(2022, 6, 30)), "JDBC sini koldonup proektti buturgulo");
        Task task4 = new Task((LocalDate.of(2022, 4, 25)), "Zapolnite massiv randomnymi chislami");
        Task task5 = new Task((LocalDate.of(2022, 5, 19)), "Polimorfizmdi koldonup 3 klass tuzgulo");
        Task task6 = new Task((LocalDate.of(2022, 7, 22)), "Hibernate tti koldonup proektti buturgulo");

        Lesson lesson4 = new Lesson("Collection", "ssylkaNaVideoCollection");
        Lesson lesson1 = new Lesson("Scanner", "ssylkaNaVideoScanner");
        Lesson lesson2 = new Lesson("Random", "ssylkaNaVideoRandom");
        Lesson lesson3 = new Lesson("OOP", "ssylkaNaVideoOOP");

        Instructor instructor3 = new Instructor("Zamir", "Sabyzhanov", "zamir@gmil.com", "0700123456");
        Instructor instructor1 = new Instructor("Aijamal", "Asangazieva", "aijamal@gmail.com", "0507456789");
        Instructor instructor2 = new Instructor("Nurisa", "Mamaraimova", "nurisa@gmil.com", "0707190273");

        Course course2 = new Course("Java-6", 9, (LocalDate.of(2022, 3, 4)), "linkToTheCourseJava", "best course for java-6");
        Course course1 = new Course("Java-4", 6, (LocalDate.of(2021, 9, 1)), "linkToTheCourseJava-4", "best course for java-4");
        Course course3 = new Course("Java-5", 6, (LocalDate.of(2022, 1, 4)), "linkToTheCourseJava-5", "best course for java-5");


//
//             Course Methods
//        courseService.saveCourse(course1);
//        courseService.saveCourse(course2);
//        courseService.saveCourse(course3);
//        System.out.println(courseService.getCourseById(1L));
//        System.out.println(courseService.getCourseByName("Java-4"));
//        courseService.getAllCourses().forEach(System.out::println);
//        courseService.updateCourse(2L,course3);
//        courseService.deleteCourseById(1L);
//        courseService.deleteCourseById(2L);


        //      Instructor Methods
//        instructorService.saveInstructor(instructor1);
//        instructorService.saveInstructor(instructor2);
//        instructorService.saveInstructor(instructor3);
//        System.out.println(instructorService.getInstructorById(1L));
//        instructorService.updateInstructor(2L,new Instructor("Maksat","Agai","m@gmail.com","069789768"));
//        instructorService.deleteInstructorById(2L);
//        System.out.println(instructorService.getInstructorByCourseId(2L));
//        instructorService.assignInstructorToCourse(3L, 2L);
//        instructorService.assignInstructorToCourse(4L, 2L);
//        System.out.println(instructorService.assignInstructorToCourse(3L, 2L));
//        System.out.println(instructorService.getInstructorByCourseId(2L));


        //     Lesson Methods
//        lessonService.saveLesson(2L,lesson1);
//        lessonService.saveLesson(2L,lesson2);
//        lessonService.saveLesson(2L,lesson3);
//        lessonService.updateLesson(2L,lesson3);
//        System.out.println(lessonService.getLessonById(2L));
//        lessonService.getLessonsByCourseId(2L);

        //     Task methods
//        taskService.saveTask(2L,task1);
//        taskService.saveTask(2L,task2);
//        taskService.saveTask(2L,task3);
//        taskService.updateTask(2L,task6);
//        taskService.deleteTaskById(3L);
//        taskService.deleteTaskById(3L);
//        taskService.deleteTaskById(1L);




    }
}
