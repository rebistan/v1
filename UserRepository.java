package com.Alansari.repository;


import org.springframework.data.repository.CrudRepository;
import com.Alansari.entity.User;


/*
 * Author Rebistan
 * 
 */
public interface UserRepository extends CrudRepository<User, String> {
	User findByQidIgnoreCase(String qid);
}
