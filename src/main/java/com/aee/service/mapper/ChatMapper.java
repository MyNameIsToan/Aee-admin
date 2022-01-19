package com.aee.service.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.aee.service.models.post.Post;
import com.aee.service.models.post.Reply;
import com.aee.service.payload.response.PostResponse;
import com.aee.service.payload.response.ReplyResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {
                AuthMapper.class,
        })
public interface ChatMapper {
    @Mapping(source = "content", target = "content")
    @Mapping(source = "user", target = "user", qualifiedByName = "fromUserToUserResponse")
    @Mapping(source = "createdDate",target = "createdDate")
    @BeanMapping(ignoreByDefault = true)
    ReplyResponse fromReplyToReplyResponse(Reply reply);

    @Mapping(source = "content", target = "content")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "id",target = "id")
    @Mapping(source = "creator",target = "user", qualifiedByName = "fromUserToUserResponse")
    @BeanMapping(ignoreByDefault = true)
    PostResponse fromPostToPostResponse(Post post);

    @IterableMapping(elementTargetType = PostResponse.class)
    List<PostResponse> fromPostListToPostResponseList(List<Post> content);

    @IterableMapping(elementTargetType = ReplyResponse.class)
    List<ReplyResponse> fromReplyListToReplyResponseList(List<Reply> content);
}
