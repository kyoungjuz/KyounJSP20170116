package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;

public interface NoticeDao {
	public List<NoticeView> getList();
	public List<NoticeView> getList(int page);
	public List<NoticeView> getList(int page, String field, String query);
	
	int getSize();
	int getSize(String field, String query);
	
	int add(Notice notice);
	int add(String title, String content, String writer);
	
}
