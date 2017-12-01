package com.SocialNetworkBackEnd.Dao;

import java.util.List;

import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.Forum;

public interface ForumDAO {
	 public boolean addForum(Forum forum);
		public boolean updateForum(Forum forum);
		public boolean deleteForum(Forum forum);
		public Forum getForum(int forumId);
		public List <Forum> getAllForum();
		public boolean approveForum(Forum forum);


}
