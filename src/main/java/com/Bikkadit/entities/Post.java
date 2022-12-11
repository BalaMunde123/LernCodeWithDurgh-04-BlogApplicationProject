package com.Bikkadit.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name ="posts")
@Setter 
@Getter
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;
	@Column(name ="post-title",length =100,nullable =false)
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;   
	
	@ManyToOne
	@JoinColumn(name ="category-id")
	private Category category;
	
	@ManyToOne
	private User user;
	

}