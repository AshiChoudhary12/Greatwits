package com.gd.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.gd.common.entity.Role;
import com.gd.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1); 
		User userName = new User("abc@greatwits.com", "@123", "Ashi", "Choudhary");
		userName.addRole(roleAdmin);
		
		User savedUser = repo.save(userName);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWithTwoRoles() {
		//Role roleAdmin = entityManager.find(Role.class, 1); 
		User userRashi = new User("mvn@greatwits.com", "@123", "Rashi", "Choudhary");
		Role roleEditor = new Role(5);
		Role roleAssistent = new Role(7);
		userRashi.addRole(roleEditor);
		userRashi.addRole(roleAssistent);
		
		User savedUser = repo.save(userRashi);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void testGetUserById() {
		User userName = repo.findById(1).get();
		System.out.println(userName);
		assertThat(userName).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		User userName = repo.findById(1).get();
		userName.setEnabled(true);
		userName.setEmail("afs@gmail.com");
		
		repo.save(userName);
	}
	
	@Test
	public void testUpdateUserRoles() {
		User userRashi = repo.findById(2).get();
		Role roleEditor = new Role(5);
		Role roleSalesperson = new Role(2);
		userRashi.getRoles().remove(roleEditor);
		
		userRashi.addRole(roleSalesperson);
		repo.save(userRashi);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 2;
		repo.deleteById(userId);
		
	}
	@Test
	public void testGetUserByEmail() {
		String email="abc@greatwits.com";
		User user = repo.getUserByEmail(email);
		
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testCountById() {
		Integer id = 13;
		Long countById = repo.countById(id);
		
		assertThat(countById).isNotNull().isGreaterThan(0);
	}
	@Test
	public void testDisableUser() {
		Integer id = 1;
		repo.updateEnableStatus(id, false);
	}
	
}

