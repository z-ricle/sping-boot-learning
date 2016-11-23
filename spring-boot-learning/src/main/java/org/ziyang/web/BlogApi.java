package org.ziyang.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ziyang.dal.model.Blog;
import org.ziyang.spring.pojo.JsonResult;
import org.ziyang.srv.BlogService;

import com.github.pagehelper.PageInfo;

@Controller
public class BlogApi {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private BlogService blogService;
	/*@RequestMapping("/blog/{action}")
    @ResponseBody
    JsonResult<Blog> blog(@PathVariable String action,@RequestParam("content") String content) {
		logger.debug("action:{}", action);
		logger.debug("content:{}", content);
		Blog blog = blogService.addBlog("test", content);
        return new JsonResult<Blog>(blog);
    }*/
	
	@RequestMapping("/blog/save")
    @ResponseBody
    JsonResult<Blog> blogSave(@RequestParam("title") String title, @RequestParam("content") String content) {
		logger.debug("title:{}", title);
		logger.debug("content:{}", content);
		Blog blog = blogService.blogSave(title, content);
        return new JsonResult<Blog>(blog);
    }
	
	@RequestMapping("/blog/page/list")
    @ResponseBody
    JsonResult<PageInfo<Blog>> blogPageList(@PageableDefault(page=0) Pageable pageable) {
		PageInfo<Blog> page = blogService.blogPageList(pageable.getOffset(), pageable.getPageSize());
        return new JsonResult<PageInfo<Blog>>(page);
    }
	
	@RequestMapping("/blog/home")
    String blogHome(@PageableDefault(page=0, size=2) Pageable pageable, Model model) {
		PageInfo<Blog> page = blogService.blogPageList(pageable.getOffset(), pageable.getPageSize());
		model.addAttribute("page", page);
        return "blogHome";
    }
}
