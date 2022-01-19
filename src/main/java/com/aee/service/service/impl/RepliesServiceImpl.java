package com.aee.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aee.service.models.post.Reply;
import com.aee.service.repository.post.ReplyRepository;
import com.aee.service.service.RepliesService;

@Service
public class RepliesServiceImpl implements RepliesService{

	@Autowired
	private ReplyRepository replyRepository;
	
	@Override
	public void Remove(Long id) {
		Reply reply = replyRepository.getOne(id);
		if(reply != null) {
			replyRepository.delete(reply);
		}
	}

}
