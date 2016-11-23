package org.ziyang.srv.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ziyang.dal.mapper.BlogMapper;
import org.ziyang.dal.model.Blog;
import org.ziyang.dal.model.BlogExample;
import org.ziyang.srv.BlogService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BlogServiceImpl implements BlogService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private BlogMapper blogMapper;
	@Transactional
	@Override
	public Blog blogSave(String title, String content) {
		Date now = new Date();
		Blog record = new Blog();
		record.setContent(content);
		record.setCreatedTime(now);
		record.setReviseTime(now);
		record.setTitle(title);
		blogMapper.insert(record);
		logger.debug("blog id:{}", record.getId());
		return record;
	}
	@Override
	public List<Blog> blogList() {
		BlogExample example = new BlogExample();
		//BlogExample.Criteria criteria = example.createCriteria();
		List<Blog> list = blogMapper.selectByExample(example);
		return list;
	}
	@Override
	public PageInfo<Blog> blogPageList(int offset, int pageSize) {
		PageHelper.startPage(offset, pageSize);
		BlogExample example = new BlogExample();
		//BlogExample.Criteria criteria = example.createCriteria();
		List<Blog> list = blogMapper.selectByExample(example);
		return new PageInfo<Blog>(list);
	}

}
