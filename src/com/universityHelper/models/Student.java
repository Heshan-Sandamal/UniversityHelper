package com.universityHelper.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.jboss.resteasy.spi.touri.MappedBy;

import com.universityHelper.controllers.StudentSignUp;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Type(type = "objectid")
	private String studentId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	private Date dob;
	private String homeTown;
	
	private String aboutMe;public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}public String getAboutMe() {
		return aboutMe;
	}

	private String fburl;

	private int examYear;

	private String email;

	public int getExamYear() {
		return examYear;
	}

	public void setExamYear(int examYear) {
		this.examYear = examYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFburl() {
		return fburl;
	}

	public void setFburl(String fburl) {
		this.fburl = fburl;
	}

	@OneToOne(mappedBy = "student")
	@JoinColumn(name = "studentProfileFK", nullable = false)
	private StudentProfile studentProfile;

	private String contactNo;

	@ManyToOne
	private Course course;

	@OneToMany(mappedBy = "student", orphanRemoval = true)
	private Set<Post> postList;

	@OneToMany(mappedBy = "student", orphanRemoval = true)
	private Set<ApartmentComment> apartmentComment;

	@ManyToMany(mappedBy = "studentSubscribers")
	private Set<Apartment> subscribedApartments;

	@OneToMany(mappedBy = "student",fetch=FetchType.EAGER)
	private Set<CommentNotification> commentNotification;

	public void setCommentNotification(Set<CommentNotification> commentNotification) {
		this.commentNotification = commentNotification;
	}

	public Set<CommentNotification> getCommentNotification() {
		return commentNotification;
	}

	public Set<Comment> getPostComments() {
		return postComments;
	}

	public void setPostComments(Set<Comment> postComments) {
		this.postComments = postComments;
	}

	@OneToMany(mappedBy = "student", orphanRemoval = true)
	private Set<Comment> postComments;

	public Set<Apartment> getSubscribedApartments() {
		return subscribedApartments;
	}

	public void setSubscribedApartments(Set<Apartment> subscribedApartments) {
		this.subscribedApartments = subscribedApartments;
	}

	public Set<Post> getPostList() {
		return postList;
	}

	public void setPostList(Set<Post> post) {
		this.postList = postList;
	}

	public Set<ApartmentComment> getApartmentComment() {
		return apartmentComment;
	}

	public void setApartmentComment(Set<ApartmentComment> apartmentComment) {
		this.apartmentComment = apartmentComment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public StudentProfile getStudentProfile() {
		return studentProfile;
	}

	public void setStudentProfile(StudentProfile studentProfile) {
		this.studentProfile = studentProfile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Student() {
		super();
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public boolean equals(Object obj) {
		Student student = (Student) obj;
		if (studentId.equals(student.getStudentId())) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return this.studentId;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return studentId.hashCode();
	}

}
