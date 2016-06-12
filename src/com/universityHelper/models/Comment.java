package com.universityHelper.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable,Comparable<Comment>{

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String id;

	private String content;

	@Sort
	private Date timeStamp;

	@ManyToOne
	private Post post;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	private Student student;

	public Comment() {
		super();
	}

	@Override
	public int compareTo(Comment comment) {
		//Comment comment=(Comment)ob;
		System.out.println("COmaringgg");
		if (this.getTimeStamp().before(comment.getTimeStamp())) {
			return 1;
		} else {
			return -1;
		}

	}

}
