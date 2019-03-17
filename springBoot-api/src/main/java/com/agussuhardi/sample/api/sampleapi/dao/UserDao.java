package com.agussuhardi.sample.api.sampleapi.dao;

import com.agussuhardi.sample.api.sampleapi.orm.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, String> {

}
