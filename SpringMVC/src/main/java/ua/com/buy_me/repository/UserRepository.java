package ua.com.buy_me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import ua.com.buy_me.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	public UserDetails findByUsername(String username);
	
	
	@Query(value="select distinct u from User u left join fetch u.commodities c where u.id =:id")
	public User fetchUser(@Param("id") int id);
}
