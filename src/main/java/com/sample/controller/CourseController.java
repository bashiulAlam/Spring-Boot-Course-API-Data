package com.sample.controller;

import com.google.gson.Gson;
import com.sample.model.Course;
import com.sample.model.CourseService;
import com.sample.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sabab on 10/7/2019.
 */

@RestController
public class CourseController {

    private static Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        logger.info("Getting all course under topic : {}...", topicId);
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId) {
        logger.info("Getting course by id : {}", courseId);
        return courseService.getCourseById(courseId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        logger.info("Adding a new course under topic {}...", topicId);
        String jsonReqBody = new Gson().toJson(course);
        logger.debug("Request Body : {}", jsonReqBody);
        courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
        course.setTopic(new Topic(topicId, "", ""));
        logger.info("Updating course with id : {}, under topic : {}", courseId, topicId);
        String jsonReqBody = new Gson().toJson(course);
        logger.debug("Request Body : {}", jsonReqBody);
        courseService.updateCourse(courseId, course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }
}
