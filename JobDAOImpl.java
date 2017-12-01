package com.SocialNetworkBackEnd.Dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SocialNetworkBackEnd.Model.Job;

@Repository("jobDAO")
	@Transactional    //all methods are run under transaction
	public class JobDAOImpl implements JobDAO{

		@Autowired
		private SessionFactory SessionFactory;
		
		public boolean addJob1(Job job) {
			try {
				SessionFactory.getCurrentSession().save(job);
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
		}


		public boolean updateJob1(Job job) {
			try{
				SessionFactory.getCurrentSession().saveOrUpdate(job);
				return true;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
				
			}
		}

		public boolean deleteJob1(Job job) {
			try{
				SessionFactory.getCurrentSession().delete(job);
				return true;
				
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured"+e);
				return false;
			}
			
		}


		public Job getJob1(int jobId) {
			Session session = SessionFactory.openSession();
			Job job = session.get(Job.class, jobId);
			session.close();
			return job;

	}


		public boolean addJob(Job job) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean updateJob(Job job) {
			// TODO Auto-generated method stub
			return false;
		}


		public boolean deleteJob(Job job) {
			// TODO Auto-generated method stub
			return false;
		}


		public Job getJob(int jobId) {
			// TODO Auto-generated method stub
			return null;
		}

}
