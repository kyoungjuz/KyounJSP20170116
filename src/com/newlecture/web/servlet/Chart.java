package com.newlecture.web.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chart
 */
@WebServlet("/Chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String url="images/foto/duga5.jpg";
		ServletContext context = request.getServletContext();
		String path= context.getRealPath(url);
		
		System.out.println(path);
		BufferedImage image = ImageIO.read(new File(path));
		
		Graphics g = image.createGraphics();
		
		//기본라인 + 색깔 입히기
		g.setColor(Color.black);
		g.drawString("누적상대도수(%)", 455, 50);
		g.drawString("인원(명)", 10, 50);
		g.setColor(Color.blue);
		g.drawString("▲", 25, 65);
		g.drawLine(31, 65, 31, 350);
		g.drawLine(500,340,20, 340);
		g.drawString("▶", 500, 345);
		g.setColor(Color.RED);
		g.drawLine(495, 65, 495, 350);
		g.drawString("▲", 489, 65);
		
		//식별자 붙이기+점선+색깔
		for(int i=1; i<6; i++){
			for(int j=30; j<495; j=j+5){
				g.setColor(Color.GREEN);
				g.drawString(" - ", j, 350-50*i);
				g.setColor(Color.black);
				g.drawString(i*2+"", 10, 350-50*i);
				g.drawString(i*20+"", 505, 350-50*i);
				
		}
		}
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "jpg", os);
	}

}
