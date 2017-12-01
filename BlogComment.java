package com.SocialNetworkBackEnd.Model;

	import java.io.Serializable;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.springframework.stereotype.Component;

	@Entity
	@Table(name = "BlogComment")
	@Component
	public class BlogComment implements Serializable{

		private static final long serialVersionUID = 1L;
		
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ID;
		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}
		
		
	}


