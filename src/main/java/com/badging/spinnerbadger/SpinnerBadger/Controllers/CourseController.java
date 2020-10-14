package com.badging.spinnerbadger.SpinnerBadger.Controllers;

import com.badging.spinnerbadger.SpinnerBadger.Models.Course;
import com.badging.spinnerbadger.SpinnerBadger.Services.Intefaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService mCourseService;

    @PostMapping("save")
    public Course save(@RequestBody Course course) {
        return mCourseService.save(course);
    }

    @PostMapping("save_all")
    public List<Course> saveCourses(@RequestBody List<Course> courses) {
        return mCourseService.saveAll(courses);
    }

    @GetMapping("get?{title}&(exact)")
    public List<Course> getCourseByExactTitle(@PathVariable(name = "title") String title ,
                                              @PathVariable(name = "exact") boolean exact ) {
        if (exact)
            return mCourseService.getCourseByExactTitle(title);
        else
            return mCourseService.getCourseByTitleContaining(title);
    }

    @GetMapping("all")
    public List<Course> getAllCourse() {
        return mCourseService.getAllCourse();
    }
}
