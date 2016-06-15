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

public class Post implements Serializable, Comparable<Post> {

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

	@ManyToOne(cascade = CascadeType.MERGE)
	private Student student;

	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<Comment> comments;

	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<CommentNotification> commentNotification;

	public void setCommentNotification(Set<CommentNotification> commentNotification) {
		this.commentNotification = commentNotification;
	}

	public Set<CommentNotification> getCommentNotification() {
		return commentNotification;
	}

	@Override
	public int compareTo(Post post) {
		if (this.getDateTime().before(post.getDateTime())) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public boolean equals(Object ob) {
		Post post = (Post) ob;

		if (post.getId().equals(this.getId())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return this.id;
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return this.id.hashCode();
		} else {
			return super.hashCode();
		}

	}

}
