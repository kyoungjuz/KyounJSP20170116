package com.newlecture.web.data.entity;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.data.oracle.OracleMemberDao;
import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;
public class Program2 {

	public static void main(String[] args) {

		// =====================Controller==========================
		String uid;
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� ���̵� : ");
		uid = sc.nextLine();

		MemberDao memberDao = new OracleMemberDao();
		List<Member> list = memberDao.getList(uid);

		// =====================Model: ����� ������===========================

		// =========================View=======================================
		for (Member m : list)
			System.out.printf("ID�� '%s'�̰� ��й�ȣ�� '%s'�̴�\n", m.getId(), m.getPwd());
		
		
		Member t=new Member();
		t.setId("�̽�Ʈsi");
		t.setPwd("11111");
		t.setName("��������");
		
		memberDao.add(t);
		list = memberDao.getList(uid);
		System.out.println("�ݾҽ��ϴ�.");
	}
}