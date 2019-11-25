package com.sample.repository;

import com.sample.model.Course;
import com.sample.model.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findByName(String name);

    public List<Course> findByDescription(String description);

    public List<Course> findByTopicId(String topicId);
}
