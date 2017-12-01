package com.SocialNetworkBackEnd.Dao;

	import java.util.List;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

    import com.SocialNetworkBackEnd.Model.Blog;

	@Repository
	public class BlogDAOImpl implements BlogDAO {
	@Autowired 
	SessionFactory sessionFactory;
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean addBlog(Blog blog) {
	try
	{
	sessionFactory.getCurrentSession().save(blog);
	return true;
	}
	catch (Exception e)
	{
	return false;
	}
	}


	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}


	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
