package com.sys.courses.back.services;

import com.sys.courses.back.models.Course;
import com.sys.courses.back.models.Exam;

import java.util.Set;

public interface CourseService {

    Course addCourse(Course course);
    Course updateCourse(Course course);
    Set<Course> getCourses();
    Course getCourse(Long courseId);
    void deleteCourse(Long courseId);
}
