package com.nicho.shops.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nicho.shops.entity.Advertisement;

public interface AdvertisementDao extends PagingAndSortingRepository<Advertisement, Long>, JpaSpecificationExecutor<Advertisement> {

 
	@Modifying
	@Query("delete from Advertisement ad where ad.id=?1")
	void deleteByAdvertisementId(Long id);
}
