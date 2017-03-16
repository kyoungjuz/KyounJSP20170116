package com.newlecture.web.data.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public class OracleNoticeDao implements NoticeDao {

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
		String sql = "SELECT  * FROM NOTICE_ViEW WHERE "+field+"'%"+query+"%'";
	      
	      List<NoticeView> list = new ArrayList<>();
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql);
	         
	         Notice notice = null;
	         
	         while(rs.next()){
	            notice= new Notice();
	            notice.setCode(rs.getString("CODE"));
	            notice.setTitle(rs.getString("TITLE"));
	            notice.setContent(rs.getString("CONTENT"));
	            notice.setWriter(rs.getString("WRITER"));
	            notice.setRegDate(rs.getDate("REGDATE"));
	            notice.setHit(rs.getInt("HIT"));
	            
	            list.add((NoticeView) notice);
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
}
