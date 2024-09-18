package com.kodbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entity.Post;
import com.kodbook.repository.PostRepository;

@Service
public class PostServiceImplementation implements PostService{
	@Autowired
	PostRepository repo;

	@Override
	public void createPost(Post post) {
		
		repo.save(post);	
	}

	@Override
	public List<Post> getAllPost() {
		
		return repo.findAll();
	}

	@Override
	public List<Post> fetchAllPosts() {
		
		return repo.findAll();
	}

	@Override
	public Post getPost(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		repo.save(post);
		
	}


}
