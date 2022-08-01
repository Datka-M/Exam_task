package org.example.config;


import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import java.util.Properties;

public class Config {

    public static SessionFactory getSession(){
        Configuration configuration = new Configuration();
        Properties prop = new Properties();
        prop.setProperty("connection.driver_class","com.postgresql.Driver");
        prop.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/hibernate");
        prop.setProperty("hibernate.connection.username","postgres");
        prop.setProperty("hibernate.connection.password","1234");
        prop.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql","true");
        prop.setProperty("hibernate.hbm2ddl.auto","update");
        prop.setProperty("hibernate.current_session_context_class","thread");
        configuration.setProperties(prop);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Task.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Connected");
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static EntityManager getEntityManager(){
        return getSession().createEntityManager();
    }



//    1) Диаграмма боюнча бардык Entity класстарды тузуп, полелерин жазуу.
//    2) Тузулгон Entity класстардын байланыштарын(relationship) , Cascade Type тарын,
//    Fetch Type тарын туура коюп жазуу.
//    3) Course:
//    3.1) Курс кошуу учун SaveCourse() деген метод тузуп, кошулганы тууралуу message кайтаруу керек.
//    3.2) Курста getCourseById(), getAllCourse()(датасы боюнча сорттоп чыгаруу), updateCourse(),
//    deleteCourseById() (курсту очургондо, курска assign болгон инструктор очпошу керек, курсун
//    ичиндеги сабактар очуш керек) ,getCourseByName() методдорун тузуп, ишке ашыруу.
//    4) Instructor:
//    4.1) Инструктордо saveInstructor(), updateInstructor(), getInstructorById(),
//    getInstructorByCourseId()(тиешелуу курстун инструкторлорун чыгарып беруу),
//    deleteInstructorById()(инструктор очкондо, инструкторго тиешелуу курс очпошу керек),
//    assignInstructorToCourse()(инструкторду курска кошуп коюу(назначить)).
//    5) Lesson:
//    5.1) Lesson да saveLesson()(Lesson сакталып жатканда кандайдыр бир курска сакталуусу керек),
//    updateLesson(), getLessonById(), getLessonsByCourseId()(курска тиешелуу сабактарды чыгаруу);
//    6) Task:
//    6.1) saveTask(), updateTask(), getAllTaskByLessonId(), deleteTaskById();
//    7) Бардык маанилер консольго так жана ирети менен чыгуусу керек .
}
