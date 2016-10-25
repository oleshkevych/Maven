package ua.com.buy_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import ua.com.buy_me.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	public UserDetails findByUsername(String username);
}
