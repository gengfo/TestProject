package com.baobaotao.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.domain.Post;
import com.baobaotao.domain.Topic;

public class TestBbtForumPfb{

	public static void main(String[] args) throws Throwable{
		
		String configPath = "classpath:applicationContext-pfb.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		BbtForum bbtForum = ctx.getBean("bbtForum",BbtForum.class);
				
    	System.out.println("begin........");
    	Topic topic = new Topic();
    	topic.setTopicTitle("Title -pfb");
    	Post post = new Post();
    	post.setPostText("post content -pfb");
    	topic.setPost(post);
    	bbtForum.addTopic(topic);
    	System.out.println("end........");
    }
}
