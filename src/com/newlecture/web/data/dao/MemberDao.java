package com.newlecture.web.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.data.entity.Member;

public interface MemberDao {
	public List<Member>getList(String query);
	int add(Member member);
		   
}
