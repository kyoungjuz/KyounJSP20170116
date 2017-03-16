package com.newlecture.web.data.mysql;

import java.util.List;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.view.NoticeView;

public class TestProgram {

	public static void main(String[] args) {
		
		NoticeDao noticedao= new MYSQLNoticeDao();
		List<NoticeView> list = noticedao.getList();
		
		for(NoticeView view : list)
			System.out.println(view.getTitle());
	}

}
