package com.SocialNetworkBackEnd.Test;



import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.SocialNetworkBackEnd.Config.AppConfig;
import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Model.UserDetails;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@WebAppConfiguration
@Transactional
public class UserTest {
  
   @Autowired
  UserDao userdao;
	@Autowired
    public UserDetails user;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Ignore
	@Test
	public void addTest()
	{
		//UserDao userdao=new UserDaoImpl(sessionFactory);
		UserDetails user=new UserDetails();
		user.setUserId(12);
		user.setUserName("abc");
		user.setRole("user");
		user.setEmailId("abc@gmail.com");
		user.setIsOnline("N");
		user.setPassword("aabb");
		System.out.println("check1");
		System.out.println(userdao);
		assertTrue("Problem in Inserting User",userdao.addUser(user));
		System.out.println("check2");
		System.out.println("EmailID:"+user.getEmailId());
		System.out.println("UserName:"+user.getUserName());
	}
}