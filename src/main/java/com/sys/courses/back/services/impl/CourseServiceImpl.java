package com.sys.courses.back.services.impl;

import com.sys.courses.back.models.Course;
import com.sys.courses.back.repositories.CourseRepository;
import com.sys.courses.back.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Set<Course> getCourses() {
        return new LinkedHashSet<>(courseRepository.findAll());
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = new Course();
        course.setCourseId(courseId);
        courseRepository.delete(course);
    }
}
