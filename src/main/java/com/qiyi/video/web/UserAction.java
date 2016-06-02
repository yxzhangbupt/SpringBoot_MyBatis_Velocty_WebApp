package com.qiyi.video.web;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qiyi.video.domain.User;
import com.qiyi.video.service.UserService;


@RestController
@RequestMapping(value="/users")
@EnableAutoConfiguration
public class UserAction {
	
	@Autowired
	private UserService userService;
	
	ConcurrentHashMap<Integer,User> users = new ConcurrentHashMap<Integer,User>();

	@RequestMapping(value="/",method=RequestMethod.GET)
	public  Collection<User> getUserList(){
		return userService.getUserList();
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String addUser(@ModelAttribute User user){
		users.put(user.getId(), user);
		return "success";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User getUser(@PathVariable long id){
		return users.get(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable int id,@ModelAttribute User user){
		User oldUser = users.get(id);
		if(oldUser==null)
			addUser(user);
		else 
			users.put(id, user);
		return "success";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable long id){
		users.remove(id);
		return "success";
	}
}
