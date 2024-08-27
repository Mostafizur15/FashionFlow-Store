package ecommerce.DAO;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ecommerce.model.UserDetails;
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean registerUser(UserDetails user) {
		try {
			this.hibernateTemplate.save(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(UserDetails user) {
		try {
			this.hibernateTemplate.update(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public UserDetails getUser(String userName) {
		try {
			UserDetails userDetail=this.hibernateTemplate.load(UserDetails.class, userName);
			Hibernate.initialize(userDetail);
			return userDetail;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
