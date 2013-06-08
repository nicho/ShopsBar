package com.nicho.shops.web.front;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
@RequestMapping(value = "/index")
public class IndexController {


	@RequestMapping(value = "")
	public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request) {

		return "front/index";
	}


}
