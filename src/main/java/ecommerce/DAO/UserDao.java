package ecommerce.DAO;

import ecommerce.model.UserDetails;
public interface UserDao {
	public boolean registerUser(UserDetails user);
	public boolean updateUser(UserDetails user);
	public UserDetails getUser(String userName);
}
