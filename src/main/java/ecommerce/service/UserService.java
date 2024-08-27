package ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.DAO.UserDao;
import ecommerce.model.UserDetails;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;
	public boolean registerUser(UserDetails user) {
		return this.userDao.registerUser(user);
	}
	public boolean updateUser(UserDetails user) {
		return this.userDao.updateUser(user);
	}
	public UserDetails getUser(String userName) {
		return this.userDao.getUser(userName);
	}
}
