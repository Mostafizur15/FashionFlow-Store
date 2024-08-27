package ecommerce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecommerce.DAO.OrderDao;
import ecommerce.model.OrderDetail;
@Service
@Transactional
public class OrderService {
	@Autowired
	OrderDao orderDao;
	public boolean saveOrder(OrderDetail order) {
		return this.orderDao.saveOrder(order);
	}
	public boolean updateCart(String userName) {
		return this.orderDao.updateCart(userName);
	}
	
}
