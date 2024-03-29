package com.sample.model;

import com.sample.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sabab on 10/9/2019.
 */

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopic() {
        //return topicList;

        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);

        return topics;
    }

    public Topic getTopicById(String id) {
        //return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();

        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
        //topicList.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        /*for (Topic topicItem : topicList) {
            if (topicItem.getId().equals(id)) {
                topicList.set(topicList.indexOf(topicItem), topic);
                return;
            }
        }*/

        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topicList.removeIf(t -> t.getId().equals(id));

        topicRepository.delete(id);
    }
}
