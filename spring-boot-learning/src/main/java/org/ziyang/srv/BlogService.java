package org.ziyang.srv;

import java.util.List;

import org.ziyang.dal.model.Blog;

import com.github.pagehelper.PageInfo;

public interface BlogService {
	Blog blogSave(String title, String content);
	List<Blog> blogList();
	PageInfo<Blog> blogPageList(int offset, int pageSize);
}
