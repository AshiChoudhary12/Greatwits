package com.gd.admin.user;


import org.junit.jupiter.api.Test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gd.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query()
	public User getUserByEmail(@Param("email") String email);

	public Long countById(Integer id);
	@Query("UPDATE User SET enabled = ?2 Where id = ?1")
	@Modifying
	public void updateEnableStatus(Integer id, boolean enabled);
}
