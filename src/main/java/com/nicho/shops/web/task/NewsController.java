package com.nicho.shops.web.task;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Maps;
import com.nicho.shops.entity.News;
import com.nicho.shops.entity.User;
import com.nicho.shops.service.account.ShiroDbRealm.ShiroUser;
import com.nicho.shops.service.task.NewsService;


/**
 * News管理的Controller, 使用Restful风格的Urls:
 * 
 * List page : GET /news/ Create page : GET /news/create Create action : POST
 * /news/create Update page : GET /news/update/{id} Update action : POST
 * /news/update Delete action : GET /news/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {

	private static final int PAGE_SIZE = 3;

	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("title", "标题");
	}

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "")
	public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Long userId = getCurrentUserId();

		Page<News> newss = newsService.getUserNews(userId, searchParams, pageNumber, PAGE_SIZE, sortType);

		model.addAttribute("newss", newss);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "news/newsList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("news", new News());
		model.addAttribute("action", "create");
		return "news/newsForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid News newNews, RedirectAttributes redirectAttributes) {
		User user = new User(getCurrentUserId());
		newNews.setUser(user);

		newsService.saveNews(newNews);
		redirectAttributes.addFlashAttribute("message", "创建新闻成功");
		return "redirect:/news/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("news", newsService.getNews(id));
		model.addAttribute("action", "update");
		return "news/newsForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preloadNews") News news, RedirectAttributes redirectAttributes) {
		newsService.saveNews(news);
		redirectAttributes.addFlashAttribute("message", "更新新闻成功");
		return "redirect:/news/";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		newsService.deleteNews(id);
		redirectAttributes.addFlashAttribute("message", "删除新闻成功");
		return "redirect:/news/";
	}

	/**
	 * 使用@ModelAttribute, 实现Struts2
	 * Preparable二次部分绑定的效果,先根据form的id从数据库查出News对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此本方法在该方法中执行.
	 */
	@ModelAttribute("preloadNews")
	public News getNews(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return newsService.getNews(id);
		}
		return null;
	}

	/**
	 * 取出Shiro中的当前用户Id.
	 */
	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}
