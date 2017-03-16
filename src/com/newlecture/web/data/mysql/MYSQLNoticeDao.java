package com.newlecture.web.data.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public class MYSQLNoticeDao implements NoticeDao {

	@Override
	public List<NoticeView> getList() {
		// TODO Auto-generated method stub
		return getList(1,"TITLE","");
	}

	@Override
	public List<NoticeView> getList(int page) {
		// TODO Auto-generated method stub
		return getList(page,"TITLE","");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) {
		String sql = "SELECT* FROM NOTICE_VIEW WHERE BINARY "+field+" LIKE ? limit ?,10";
	      
	      List<NoticeView> list = new ArrayList<>();
	      
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, "%"+query+"%");
	         st.setInt(2, 10*(page-1));
	         
	         ResultSet rs = st.executeQuery();
	         
	         NoticeView notice = null;
	         
	         while(rs.next()){
	            notice= new NoticeView();
	            notice.setCode(rs.getString("CODE"));
	            notice.setTitle(rs.getString("TITLE"));
	            notice.setContent(rs.getString("CONTENT"));
	            notice.setWriter(rs.getString("WRITER"));
	            notice.setRegDate(rs.getDate("REGDATE"));
	            notice.setHit(rs.getInt("HIT"));
	            //NoticeView 컬럼
	            notice.setWriterName(rs.getString("WRITER_NAME"));
	            notice.setCommentCount(rs.getInt("COMMENT_COUNT"));
	            
	            list.add(notice);
	         }
	      
	         rs.close();
	         st.close();
	         con.close();
	                  
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return list;
	   }

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return getSize("TITLE","");
	}

	@Override
	public int getSize(String field, String query) {
		String sql = "SELECT COUNT(CODE) SIZE FROM NOTICE WHERE BINARY "+field+" LIKE ?";
	      int size=0;
	     
	      
	      try {
	         Class.forName("com.mysql.jdbc.Driver");
	         
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, "%"+query+"%");
	      
	         
	         ResultSet rs = st.executeQuery();
	         if(rs.next())
	         size=rs.getInt("SIZE");
	         
	         rs.close();
	         st.close();
	         con.close();
	                  
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return size;
	   }

	@Override
	public int add(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(String title, String content, String writer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
