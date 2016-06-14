package com.universityHelper.services;

import java.util.ArrayList;

import javax.ejb.Local;

import com.universityHelper.models.Comment;
import com.universityHelper.models.Post;

@Local
public interface PostServiceLocal {
	public boolean addPost(String studentId,Post post);
	public Post viewPostDetails(String postId);
	public boolean addComment(Comment acm, String postId, String studentId);
	public ArrayList<Post> getAllPosts();
	public ArrayList<Post> getPostsOfStudent(String studentId);
	public boolean deletePost(String postId);
	public boolean updatePost(String studentId, Post post);
}
