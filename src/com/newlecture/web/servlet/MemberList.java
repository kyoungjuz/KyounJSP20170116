package com.newlecture.web.servlet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.data.mysql.MYSQLMemberDao;

@WebServlet("/memberlist")
public class MemberList extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		String query= request.getParameter("query");
		
		System.out.println(query);
				
		/*response.setCharacterEncoding("UTF-8");*/
		response.setContentType("text/html; charset=UTF-8"); //���� ����
		
		
		PrintWriter out = response.getWriter();
		
		MemberDao memberDao = new MYSQLMemberDao();
		List<Member> list = memberDao.getList(query);
		
		for (Member m : list)
			out.printf("ID�� '%s'�̰� ��й�ȣ�� <span style='color:red;'>'%s'</span>�̴�\n<br />", m.getId(), m.getPwd());
	}
}
