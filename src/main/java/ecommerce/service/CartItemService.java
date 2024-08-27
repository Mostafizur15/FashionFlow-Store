package ecommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.DAO.CartDao;
import ecommerce.model.CartItem;

@Service
@Transactional
public class CartItemService {

	@Autowired
	CartDao cartDao;
	public boolean saveCart(CartItem cart) {
		return this.cartDao.addCart(cart);
	}
	public boolean deleteCart(CartItem cart) {
		return this.cartDao.deleteCart(cart);
	}
	public List<CartItem> getAllCart(String userName){
		return this.cartDao.listOfCart(userName);
	}
	public CartItem getCart(int categoryId) {
		CartItem cart = this.cartDao.getCart(categoryId);
		return cart;
	}
	public boolean updateCart(CartItem cart) {
		return this.cartDao.updateCart(cart);
	}
}
