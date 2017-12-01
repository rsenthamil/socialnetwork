package com.SocialNetworkBackEnd.Test;


	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;
	import org.junit.BeforeClass;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.SocialNetworkBackEnd.Dao.JobDAO;
import com.SocialNetworkBackEnd.Model.Job;

	

	public class JobTest {

		
	private static final Object Forum = null;
		
		public static AnnotationConfigApplicationContext context;
		private static JobDAO jobDAO;
		private Job job;
		
		@BeforeClass
		public static void init(){
			context =new AnnotationConfigApplicationContext();
			context.scan("com.SocialNetworkBackEnd");
			context.refresh();
			jobDAO =(JobDAO) context.getBean("jobDAO");
		}
		
		
		@Ignore
		@Test
		public  void addJobTest() {
			Job job = new Job();
			job.setJobdate("22dec2011");
			job.setJobprofile("be");
			job.setPostdate("22dec2011");
			job.setQualification("be");
			job.setStatus("A");
			
			
			
		
			assertEquals("Failed to add!",true,jobDAO.addJob(job));
			
		} 
		
		@Test
		public void updateJobTest(){
		
			//Blog blog = (Blog)blogDAO.getBlog(1);
			Job job=(Job)jobDAO.getJob(1);
	    job.setQualification("software engineer");
			
			assertTrue("Problem in updation",jobDAO.updateJob(job));
		}
		
	}


