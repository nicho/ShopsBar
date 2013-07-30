package com.nicho.shops.service.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nicho.shops.entity.Advertisement;

@Component
@Transactional(readOnly = true)
public class AdvertisementService {
	public List<Advertisement> getAllAdvertisement() {
		Advertisement at = new Advertisement();
		at.setId(new Long(1));
		at.setTitle("广告1投放");
		at.setDescription("广告1投放描述");
		at.setBackgroundImageUrl("/static/images/slide-01.jpg");
		at.setOpenUrl("#");
		at.setOpenBtnName("广告1详细");
		Advertisement at1 = new Advertisement();
		at1.setId(new Long(2));
		at1.setTitle("广告2投放");
		at1.setDescription("广告2投放描述");
		at1.setBackgroundImageUrl("/static/images/slide-02.jpg");
		at1.setOpenUrl("#");
		at1.setOpenBtnName("广告2详细");
		Advertisement at2 = new Advertisement();
		at2.setId(new Long(3));
		at2.setTitle("广告3投放");
		at2.setDescription("广告3投放描述");
		at2.setBackgroundImageUrl("/static/images/slide-03.jpg");
		at2.setOpenUrl("#");
		at2.setOpenBtnName("广告3详细");
		List<Advertisement> AdvertisementList = new ArrayList<Advertisement>();
		AdvertisementList.add(at);
		AdvertisementList.add(at1);
		AdvertisementList.add(at2);
		return AdvertisementList;
	}
}
