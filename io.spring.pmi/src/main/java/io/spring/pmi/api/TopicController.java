package io.spring.pmi.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.pmi.model.Topic;
import io.spring.pmi.service.TopicService;
@RequestMapping("/api/v1/topic")
@RestController
public class TopicController {
	
	private final TopicService topicSerice;
	
	@Autowired
	public TopicController(TopicService topicSerice) {
		
		this.topicSerice = topicSerice;
	}
	@PostMapping
	public void iaddTopic(@RequestBody Topic topic)
	{
		topicSerice.insertTopic(topic);
	}
	@GetMapping
	public List<Topic> getAllTopic()
	{
		return topicSerice.getAllTopics();
	}
	
	@GetMapping(path = "/{id}")
	public Topic selectPersonByID(@PathVariable("id") UUID id)
	{
		return topicSerice.selectTopicByID(id).orElse(null);
	}
	@DeleteMapping(path = "/{id}")
	public void deleteTopicById(@PathVariable("id") UUID id)
	{
		topicSerice.deleteTopic(id);
	}
	
	@PutMapping("/{id}")
	public void updateTopic(@PathVariable("id") UUID id,@RequestBody Topic topic)
	{
		topicSerice.updateTopic(id, topic);
	}
	

}
