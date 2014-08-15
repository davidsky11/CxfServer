package com.kn.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kn.bean.Comments;
import com.kn.service.CommentsService;

public class CommentsTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"config/jaxws-services.xml");
		CommentsService comm = (CommentsService) context
				.getBean("commentsClient");
		System.out.println(" ************************ ");
		// comm.insertCommentGet("baseline", "nk", "kevin", 1,
		// "only insert one record");

		List<Comments> list = new ArrayList<Comments>();
		list = comm.findCommentsByName("kevin", 1);
		System.out.println("  list size : " + list.size() + "\n");
		for (Comments c : list) {
			System.out.println(" id : " + c.getId() + " > created : " 
					+ c.getCreated_at() + " > text : " + c.getText() 
					+ " > source : " + c.getSource() + " > username: " 
					+ c.getUsername() + " > zhihuId : " + c.getZhihuId()
					+ " > reply : " + c.getReply_comment() + "\n");
		}
		// System.out.println(" name 'admin' --> id '" + id + "'");
	}
}
