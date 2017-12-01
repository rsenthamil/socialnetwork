package com.SocialNetworkBackEnd.Test;
import static org.junit.Assert.*;



import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SocialNetworkBackEnd.Dao.BlogDAO;
import com.SocialNetworkBackEnd.Model.Blog;

public class BlogTest 
{

	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.SocialNetworkBackEnd.*");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogId(1001);
		blog.setBlogName("Core Java");
		blog.setBlogContent("It is based on Simple Java Concept");
		blog.setUsername("sunil");
		blog.setStatus("A");
		blog.setLikes(3);
		blog.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	}
}