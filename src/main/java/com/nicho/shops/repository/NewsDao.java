package com.nicho.shops.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nicho.shops.entity.News;

public interface NewsDao extends PagingAndSortingRepository<News, Long>, JpaSpecificationExecutor<News> {

	Page<News> findByUserId(Long id, Pageable pageRequest);

	@Modifying
	@Query("delete from News news where news.user.id=?1")
	void deleteByUserId(Long id);
}
