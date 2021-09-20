package io.spring.pmi.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



import io.spring.pmi.model.Topic;

public interface TopicDao {
	
	public int insertTopic(UUID id,Topic topic);
	List<Topic> getAllTopics();
	int deleteTopicById(UUID id);
	int updateTopicByID(UUID id, Topic Topic);
	Optional<Topic> selelctTopicByID(UUID id); 
	
	default int addTopic(Topic topic) {
		
		UUID id =UUID.randomUUID();
		insertTopic(id , topic);
		return 1;
	}

}
