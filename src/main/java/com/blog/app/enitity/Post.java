package com.blog.app.enitity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	private String postTitle;
	
	@Column(length = 10000)
	private String postContent;
	
	private String imageName;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updateDate;
}
