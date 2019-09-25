package com.Alansari.repository;

import org.springframework.data.repository.CrudRepository;

import com.Alansari.entity.ConfirmationToken;

/*
 * Author Rebistan
 * 
 */

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
