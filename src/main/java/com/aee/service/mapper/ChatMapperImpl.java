package com.aee.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.aee.service.models.post.Post;
import com.aee.service.models.post.Reply;
import com.aee.service.payload.response.PostResponse;
import com.aee.service.payload.response.ReplyResponse;

public class ChatMapperImpl implements ChatMapper {

	AuthMapper authMapper;
	
	public ChatMapperImpl() {
		this.authMapper = new AuthMapperImpl();
	}
	
	@Override
	public ReplyResponse fromReplyToReplyResponse(Reply reply) {
		ReplyResponse replies = new ReplyResponse();
		replies.setContent(reply.getContent());
		replies.setCreatedDate(reply.getCreatedDate());
		replies.setUser(authMapper.fromUserToUserResponse(reply.getUser()));
		return replies;
	}

	@Override
	public PostResponse fromPostToPostResponse(Post post) {
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(post.getContent());
		postResponse.setCreatedDate(post.getCreatedDate());
		postResponse.setTitle(post.getTitle());
		postResponse.setId(post.getId());
		postResponse.setUser(authMapper.fromUserToUserResponse(post.getCreator()));
		return postResponse;
	}

	@Override
	public List<PostResponse> fromPostListToPostResponseList(List<Post> content) {
		List<PostResponse> list = new ArrayList<>();
		for(int i = 0; i < content.size(); i++ ) {
			PostResponse postResponse = new PostResponse();
			postResponse.setContent(content.get(i).getContent());
			postResponse.setCreatedDate(content.get(i).getCreatedDate());
			postResponse.setId(content.get(i).getId());
			postResponse.setUser(authMapper.fromUserToUserResponse(content.get(i).getCreator()));
			postResponse.setTitle(content.get(i).getTitle());
			list.add(postResponse);
		}
		return list;
	}

	@Override
	public List<ReplyResponse> fromReplyListToReplyResponseList(List<Reply> content) {
		List<ReplyResponse> list = new ArrayList<>();
		for(int i = 0; i < content.size(); i++) {
			ReplyResponse replyResponse = new ReplyResponse();
			replyResponse.setContent(content.get(i).getContent());
			replyResponse.setCreatedDate(content.get(i).getCreatedDate());
			replyResponse.setUser(authMapper.fromUserToUserResponse(content.get(i).getUser()));
			list.add(replyResponse);
		}
		return list;
	}

}
