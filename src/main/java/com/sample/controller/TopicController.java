package com.sample.controller;

import com.google.gson.Gson;
import com.sample.repository.Topic;
import com.sample.repository.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sabab on 10/7/2019.
 */

@RestController
public class TopicController {

    private static Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        logger.info("Getting all topics...");
        return topicService.getAllTopic();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable String id) {
        logger.info("Getting topic by id : {}", id);
        return topicService.getTopicById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic) {
        logger.info("Adding a new topic...");
        String jsonReqBody = new Gson().toJson(topic);
        logger.debug("Request Body : {}", jsonReqBody);
        topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        logger.info("Updating topic with id : {}", id);
        String jsonReqBody = new Gson().toJson(topic);
        logger.debug("Request Body : {}", jsonReqBody);
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
