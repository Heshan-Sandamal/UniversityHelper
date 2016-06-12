package com.universityHelper.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Post implements Serializable {


	@Transient
	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String id;
	
	private String topic;
	
	private String content;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	private Date dateTime;
	
	@ManyToOne
	private Student student;
	
	@OneToMany(fetch=FetchType.EAGER)
	private Set<Comment> comments;
   
}
