package com.spring.proxy;

public interface ForumServiceTs {

    @IsProxy
    void removeTopic(int topicId);

    @IsProxy
    void removeForum(int forumId);

    void my();
}
