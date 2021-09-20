package io.spring.pmi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.spring.pmi.dao.TopicDao;
import io.spring.pmi.model.Topic;

@Service
public class TopicService {
	
	private final TopicDao topicDao;
	
	@Autowired
	public TopicService(@Qualifier("fackeDao") TopicDao topicDao) {
		super();
		this.topicDao = topicDao;
	}
	
	public int insertTopic(Topic topic)
	{
		return topicDao.addTopic(topic);
	}
	
	public List<Topic> getAllTopics()
	{
		return topicDao.getAllTopics();
	}
	
	public Optional<Topic> selectTopicByID(UUID id)
	{
		return topicDao.selelctTopicByID(id);
	}
	public int deleteTopic(UUID id)
	{
		return topicDao.deleteTopicById(id);
	}
	public int updateTopic(UUID id, Topic topic)
	{
		return topicDao.updateTopicByID(id, topic);
	}

}
