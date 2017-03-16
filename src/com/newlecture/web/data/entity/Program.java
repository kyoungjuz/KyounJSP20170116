package com.newlecture.web.data.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.newlecture.web.data.mysql.MYSQLMemberDao;
import com.newlecture.web.data.dao.MemberDao;

public class Program {

	public static void main(String[] args){
		// 자바는 데이터를 가공하는것이 아니고 UI만 만듬
		// MVC

		// =====================Controller==========================
		String uid;
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 아이디 : ");
		uid = sc.nextLine();

		MemberDao memberDao = new MYSQLMemberDao();
		List<Member> list = memberDao.getList(uid);

		// =====================Model: 출력할 데이터===========================

		// =========================View=======================================
		for (Member m : list)
			System.out.printf("ID는 '%s'이고 비밀번호는 '%s'이다\n", m.getId(), m.getPwd());
	}
}
// 구조적인 데이터를 사용하는 이유
// 구조적인 데이터= 사용자형식 =개체
// 1.
// 2. 데이터를 한번에 담아서 처리할 수 있다.

/*
 * mid = rs.getString("MID"); pwd= rs.getString("PWD");
 */

/* if(mid.contains("a")) */
/* System.out.printf("ID는 '%s'이고 비밀번호는 '%s'이다\n",mid,pwd); */