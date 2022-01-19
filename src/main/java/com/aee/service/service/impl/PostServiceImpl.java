package com.aee.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aee.service.models.post.Post;
import com.aee.service.models.post.Reply;
import com.aee.service.repository.post.PostRepository;
import com.aee.service.repository.post.ReplyRepository;
import com.aee.service.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Override
	public void Remove(Long id) {
		Post post = postRepository.getOne(id);
		if(post != null) {
			List<Reply> ListOfReplies = replyRepository.findAll();
			for(Reply reply : ListOfReplies) {
				replyRepository.delete(reply);
			}
			postRepository.delete(post);
		}
	}

}
