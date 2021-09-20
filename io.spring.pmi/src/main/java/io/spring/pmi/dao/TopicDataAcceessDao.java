package io.spring.pmi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;



import io.spring.pmi.model.Topic;
@Repository("fackeDao")
public class TopicDataAcceessDao implements TopicDao {

	List<Topic> DB = new ArrayList<>();
	@Override
	public int insertTopic(UUID id,Topic topic) {
		
		DB.add(new Topic(id,topic.getName()));
		return 1;
	}
	@Override
	public List<Topic> getAllTopics() {
		// TODO Auto-generated method stub
		return DB;
	}
	@Override
	public int deleteTopicById(UUID id) {

		Optional<Topic> topicMayBe = selelctTopicByID(id);
		if(topicMayBe.isEmpty())
			return 0;
		DB.remove(topicMayBe.get());
		return 1;
	}
	@Override
	public int updateTopicByID(UUID id, Topic topictoUpdate) {
		
		selelctTopicByID(id)
		.map(topic->
		{
			int index = DB.indexOf(topic);
			if(index>0)
			{
				DB.set(index, topictoUpdate);
			}
			return 1;
		})
		.orElse(0);
		return 0;
	}
	@Override
	public Optional<Topic> selelctTopicByID(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream().filter(topic->topic.getId().equals(id)).findFirst();
	}
	

}
