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
		// �ڹٴ� �����͸� �����ϴ°��� �ƴϰ� UI�� ����
		// MVC

		// =====================Controller==========================
		String uid;
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� ���̵� : ");
		uid = sc.nextLine();

		MemberDao memberDao = new MYSQLMemberDao();
		List<Member> list = memberDao.getList(uid);

		// =====================Model: ����� ������===========================

		// =========================View=======================================
		for (Member m : list)
			System.out.printf("ID�� '%s'�̰� ��й�ȣ�� '%s'�̴�\n", m.getId(), m.getPwd());
	}
}
// �������� �����͸� ����ϴ� ����
// �������� ������= ��������� =��ü
// 1.
// 2. �����͸� �ѹ��� ��Ƽ� ó���� �� �ִ�.

/*
 * mid = rs.getString("MID"); pwd= rs.getString("PWD");
 */

/* if(mid.contains("a")) */
/* System.out.printf("ID�� '%s'�̰� ��й�ȣ�� '%s'�̴�\n",mid,pwd); */