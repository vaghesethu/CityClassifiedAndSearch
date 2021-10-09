package com.cityclassifiedandsearch.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class VerificationToken {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	    private String token;
	  
	    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "user_id")
	    private User user;
	    
	    private Date expiryDate;
	   
	    private Date calculateExpiryDate(int expiryTimeInMinutes) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Timestamp(cal.getTime().getTime()));
	        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
	        return new Date(cal.getTime().getTime());
	    }
	    
		public VerificationToken(Long id, String token, User user, Date expiryDate) {
			super();
			this.id = id;
			this.token = token;
			this.user = user;
			this.expiryDate = expiryDate;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Date getExpiryDate() {
			return expiryDate;
		}

		public void setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate;
		}

		@Override
		public String toString() {
			return "VerificationToken [id=" + id + ", token=" + token + ", user=" + user + ", expiryDate=" + expiryDate
					+ "]";
		}
	    

}
