package com.nicho.shops.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.nicho.shops.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
	User findByLoginName(String loginName);
}
