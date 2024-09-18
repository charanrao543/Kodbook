package com.kodbook.service;

import java.util.List;

import com.kodbook.entity.Post;

public interface PostService {

	void createPost(Post post);
	
	List<Post>getAllPost();

	List<Post> fetchAllPosts();

	Post getPost(Long id);

	void updatePost(Post post);

	

}
