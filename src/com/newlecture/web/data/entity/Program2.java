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
		System.out.print("검색할 아이디 : ");
		uid = sc.nextLine();

		MemberDao memberDao = new OracleMemberDao();
		List<Member> list = memberDao.getList(uid);

		// =====================Model: 출력할 데이터===========================

		// =========================View=======================================
		for (Member m : list)
			System.out.printf("ID는 '%s'이고 비밀번호는 '%s'이다\n", m.getId(), m.getPwd());
		
		
		Member t=new Member();
		t.setId("미스트si");
		t.setPwd("11111");
		t.setName("오오오오");
		
		memberDao.add(t);
		list = memberDao.getList(uid);
		System.out.println("닫았습니다.");
	}
}