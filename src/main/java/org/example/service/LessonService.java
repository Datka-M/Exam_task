package org.example.service;

import org.example.entity.Lesson;

public interface LessonService {

    //when save lesson,save lesson to course
    void saveLesson(Long courseId,Lesson lesson1);

    void updateLesson(Long id,Lesson lesson);

    Lesson getLessonById(Long id);

    //kurska tieshelu sabaktardy chygaruu
    void getLessonsByCourseId(Long id);
}
