package ua.com.buy_me.service;

import java.util.List;

import ua.com.buy_me.entity.User;

public interface UserService {

	void save(User user);
	List<User> findAll();
	User findOneUser(int id);
	void delete(int id);
	
}
