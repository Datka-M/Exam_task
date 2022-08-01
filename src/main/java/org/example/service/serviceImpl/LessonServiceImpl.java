package org.example.service.serviceImpl;

import org.example.entity.Lesson;
import org.example.repository.LessonRepository;
import org.example.repository.impl.LessonRepoImpl;
import org.example.service.LessonService;

public class LessonServiceImpl implements LessonService {

    private LessonRepository lesson = new LessonRepoImpl();


    @Override
    public void saveLesson(Long courseId, Lesson lesson1) {
        lesson.saveLesson(courseId, lesson1);
    }

    @Override
    public void  updateLesson(Long id, Lesson lesson1) {
        lesson.updateLesson(id, lesson1);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lesson.getLessonById(id);
    }

    @Override
    public void getLessonsByCourseId(Long id) {
         lesson.getLessonsByCourseId(id);
    }
}
