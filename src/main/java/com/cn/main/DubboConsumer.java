package com.cn.main;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.model.Mobile;
import com.cn.model.User;
import com.cn.userservice.UserService;


public class DubboConsumer {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "spring/applicationConsumer.xml" });
			context.start();
			UserService userService=(UserService) context.getBean("userService");
			User user=userService.queryUser("小前","123456");
			List<Mobile> mobiles=userService.getUsermobiles(1);
			System.out.println(user.toString());
			//输出一对多的信息
			System.out.println(mobiles);
			System.in.read();
		} catch (BeansException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
