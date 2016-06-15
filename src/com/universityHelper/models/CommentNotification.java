package com.universityHelper.models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: CommentNotification
 *
 */
@Entity

public class CommentNotification implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public CommentNotification() {
		super();
	}
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	Student student;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	Post post;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	String content;
	
	int status;
	
}
