package com.revature.warlockzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.warlockzone.beans.Post;
import com.revature.warlockzone.dao.PostDAO;
import com.revature.warlockzone.services.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/post")
	public void addPost(@RequestBody Post post) {
		postService.addPost(post);
	}
	
	@RequestMapping("/post")
	public List<Post> getPosts(){
		return postService.getAllPosts();
	}
	
	@RequestMapping("/post/{id}")
	public Post getPost(@PathVariable int id){
		return postService.getPostById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/post")
	public void updatePost(@RequestBody Post post) {
		postService.updatePost(post);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/post/{id}")
	public void deletePost(@PathVariable int id) {
		postService.deletePost(id);
	}
}