package ecommerce.DAO;

import ecommerce.model.OrderDetail;

public interface OrderDao {
	public boolean saveOrder(OrderDetail order);
	public boolean updateCart(String userName);
}
