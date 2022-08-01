package org.example.repository;

import org.example.entity.Lesson;

public interface LessonRepository {

    //when save lesson,save lesson to course
    void saveLesson(Long courseId,Lesson lesson);

    void updateLesson(Long id,Lesson lesson);

    Lesson getLessonById(Long id);

    //kurska tieshelu sabaktardy chygaruu
    void getLessonsByCourseId(Long id);

}
