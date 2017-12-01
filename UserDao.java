package com.SocialNetworkBackEnd.Dao;

import org.springframework.stereotype.Service;

//import java.util.List;

import com.SocialNetworkBackEnd.Model.UserDetails;

@Service
public interface UserDao {

   public boolean addUser(UserDetails user);
   public boolean updateOnlineStatus(String status,UserDetails user);
	 //boolean saveUser(User user);
public Object getAllUser();
}