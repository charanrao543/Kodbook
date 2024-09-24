package com.kodbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook.entity.Post;
import com.kodbook.entity.User;
import com.kodbook.service.PostService;
import com.kodbook.service.UserService;

import jakarta.servlet.http.HttpSession;




@Controller
public class NavController {
	@Autowired
	UserService service;
	@Autowired
	PostService postService;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "signUp";
	}
	@GetMapping("/openCreatePost")
	public String openCreatePost(HttpSession session) {
		if(session.getAttribute("username")!=null) {
			return "createPost";
		}
		else {
			return "index";
		}
	}
	@GetMapping("/goHome")
	public String login(Model model)	{
			List<Post> allPosts = postService.fetchAllPosts();
			model.addAttribute("allPosts", allPosts);
			return "home";
	}
	@GetMapping("/openMyProfile")
	public String openMyProfile(Model model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		User user = service.getUser(username);
		model.addAttribute("user", user);
		List<Post> myPosts = user.getPosts();
		model.addAttribute("myPosts", myPosts);
		return "myProfile";
	}
	
	@GetMapping("/openEditProfile")
	public String openEditProfile(HttpSession session) {
		if(session.getAttribute("username")!=null) {
			return "editProfile";
		}
		else {
			return "index";
		}
		
	}
	
	/**
	 * @param username
	 * @param models
	 * @param session
	 * @return
	 */

	
	@PostMapping("/visitProfile")
	public String visitProfile(@RequestParam String profileName, Model model) {
	    // Fetch the user by username
	    User user = service.getUser(profileName);
	    model.addAttribute("user", user);

	    // Add user and their posts to the model
	   
	    List<Post> myPosts = user.getPosts();
		model.addAttribute("myPosts", myPosts);

	    return "showUserProfile";  // The view template for displaying the user's profile
	}
	
	
	
}