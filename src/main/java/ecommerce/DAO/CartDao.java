package ecommerce.DAO;

import java.util.List;

import ecommerce.model.CartItem;

public interface CartDao {

	public boolean addCart(CartItem cart);
	public boolean deleteCart(CartItem cart);
	public boolean updateCart(CartItem cart);
	public List<CartItem> listOfCart(String userName);
	public CartItem getCart(int cartId);
}
