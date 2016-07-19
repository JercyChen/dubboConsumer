package com.cn.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.model.User;
import com.cn.userservice.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired(required=true)
	private UserService userService;

	@RequestMapping("/login")
	public String login(@RequestParam("name") String name,
			@RequestParam("pass") String pass, HttpSession session) {
		System.out.println(name);
		User user = userService.queryUser(name, pass);
		if (user != null) {
			session.setAttribute("username", name);
			return "success";
		} else
			return "login";
	}

	@RequestMapping("/queryAllUsers")
	public String queryAllUsers(HttpServletRequest request) {
		System.out.println("��ѯ�����û���Ϣ");
		request.setAttribute("users", userService.queryAllUsers());
		return "allusersinfo";
	}

	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request) {
		request.setAttribute("types", userService.queryUserTypes());
		return "adduser";
	}
	
	@RequestMapping("/addUserInfo")
	public String addUser(@ModelAttribute User user,HttpServletRequest request)
	{
		System.out.println("����û�");
		System.out.println(user.getUserName());
		/*int flag=userService.addUser(user);
		Map<String,String> map=new HashMap<String,String>();
		if(flag!=0)
			map.put("msg","��ӳɹ�");
		else
			map.put("msg", "���ʧ��");
		return map;*/
		return "success";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request)
	{
		request.setAttribute("users", userService.queryAllUsers());
		return "deluser";
		
	}
	
	@RequestMapping("/deleteUser1")
	public String deleteUser(Integer userIds[])
	{
		List<Integer> list=Arrays.asList(userIds);
		userService.deleteUser(list);
		return "redirect:/user/queryAllUsers.do";
		
	}
}
