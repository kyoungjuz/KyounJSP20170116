package com.newlecture.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.data.mysql.MYSQLMemberDao;

@WebServlet("/joinus/member-reg")
public class MemberReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String id= request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String pwdre=request.getParameter("pwdre");
		String name=request.getParameter("name");
		String[] hobbies=request.getParameterValues("hobbies");
		String hobby=request.getParameter("hobby");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(pwdre);
		System.out.println(name);
		for(String h : hobbies)
			System.out.println(h);
		
		System.out.println(hobby);
	
	}

}
