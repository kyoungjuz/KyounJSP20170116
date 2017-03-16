package com.newlecture.web.data.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.entity.Member;
import com.newlecture.web.data.dao.MemberDao;

public class OracleMemberDao implements MemberDao {
	  public List<Member> getList(String query) {
	      String sql = "SELECT  * FROM MEMBER WHERE MID LIKE '%"+query+"%'";
	      // a가 들어간 아이디를 찾는 명령어. 자바에서는 데이터를 만지지 않는다.
	      
	      List<Member> list = new ArrayList<>();
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql);
	         
	         Member member = null;
	         
	         while(rs.next()){
	            member = new Member();
	            member.setId(rs.getString("MID"));
	            member.setPwd(rs.getString("PWD"));
	            
	            list.add(member);
	         }
	      
	         // 자원정리하기 뭐든...
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
	   public int add(Member member) {
	      String sql = "INSERT INTO MEMBER(MID, PWD, NAME, PHONE, REGDATE) VALUES(?,?,?,?,SYSDATE)";
	            
	      List<Member> list = new ArrayList<>();
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         
	         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1,  member.getId());
	         st.setString(2,  member.getPwd());
	         st.setString(3,  member.getName());
	         st.setString(4,  member.getPhone());
	         
	         //결과가 있는 쿼리 executeQuery() - SELECT
	         //결과가 없는 쿼리 executeUpdate() - INSERT, UPDATE, DELETE
	         int result = st.executeUpdate();
	         
	         st.close();
	         con.close();
	                                 
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return 0;
	   }

	}