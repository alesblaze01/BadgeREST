package com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces;


import com.badging.spinnerbadger.SpinnerBadger.Models.Course;

import java.util.List;

public interface CourseService {
    Course save(Course course);
    List<Course> saveAll(List<Course> courses);
    List<Course> getCourseByExactTitle(String title);
    List<Course> getCourseByTitleContaining(String title);
    List<Course> getAllCourse();
}
