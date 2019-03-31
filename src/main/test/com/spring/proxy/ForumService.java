package com.spring.proxy;

public interface ForumService {

    @IsProxy
    void removeTopic(int topicId);

    @IsProxy
    void removeForum(int forumId);

    void my();
}
