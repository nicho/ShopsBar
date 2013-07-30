package com.nicho.shops.web.front;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nicho.shops.entity.Advertisement;
import com.nicho.shops.service.task.AdvertisementService;


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

	@Autowired
	private AdvertisementService advertisementService;
	
	@RequestMapping(value = "")
	public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model, ServletRequest request) {
		List<Advertisement> AdvertisementList=advertisementService.getAllAdvertisement();
		request.setAttribute("AdvertisementList", AdvertisementList);
		return "front/index";
	}


}
