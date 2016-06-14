package com.universityHelper.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.runner.manipulation.Sorter;

import com.universityHelper.models.Apartment;
import com.universityHelper.models.Comment;
import com.universityHelper.models.Post;
import com.universityHelper.models.Student;

/**
 * Session Bean implementation class PostService
 */
@Stateless
@LocalBean
public class PostService implements PostServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;

	public PostService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addPost(String studentId, Post post) {

		Student student = em.find(Student.class, studentId);

		post.setStudent(student);

		Set<Post> studentPosts = student.getPostList();
		if (studentPosts == null) {
			student.setPostList(new TreeSet());
		}

		student.getPostList().add(post);

		em.persist(post);

		return true;
	}

	@Override
	public Post viewPostDetails(String postId) {
		Post post = em.find(Post.class, postId);

		ArrayList<Comment> sortedList = new ArrayList(post.getComments());
		Collections.sort(sortedList);

		post.setComments(new TreeSet<Comment>(sortedList));

		return post;
	}

	@Override
	public boolean addComment(Comment acm, String postId, String studentId) {

		Post post = em.find(Post.class, postId);
		Student student = em.find(Student.class, studentId);

		if (post != null && student != null) {

			acm.setPost(post);
			acm.setStudent(student);

			if (post.getComments() == null) {
				post.setComments(new TreeSet<Comment>());
			}

			post.getComments().add(acm);

			if (student.getPostComments() == null) {
				student.setPostComments(new TreeSet<Comment>());
			}

			student.getPostComments().add(acm);

			em.persist(acm);
			return true;
		}

		return false;
	}

	@Override
	public ArrayList<Post> getAllPosts() {
		String query = "SELECT c FROM Post c ORDER BY c.dateTime DESC";
		TypedQuery<Post> queryRes = em.createQuery(query, Post.class);

		// query.setParameter(1, );
		ArrayList<Post> list = (ArrayList<Post>) queryRes.getResultList();
		// Collections.sort(list.get(0).getComments().);
		return list;
	}

	@Override
	public ArrayList<Post> getPostsOfStudent(String studentId) {

		Student student = em.find(Student.class, studentId);

		ArrayList<Post> sortedList = new ArrayList(student.getPostList());
		Collections.sort(sortedList);

		return sortedList;
	}

	@Override
	public boolean deletePost(String postId) {
		Post post=em.find(Post.class, postId);
		em.remove(post);
		return true;
	}

	@Override
	public boolean updatePost(String studentId, Post post) {
		Post postFetched=em.find(Post.class, post.getId());
		postFetched.setContent(post.getContent());;
		postFetched.setTopic(post.getTopic());
		postFetched.setDateTime(post.getDateTime());
		em.merge(postFetched);
		return true;
	}

}
