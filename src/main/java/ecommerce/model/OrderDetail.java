package ecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	int cartId,TotalAmount;
	String userName;
	Date orderDate;
	String ShippingAddr,Trans;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		TotalAmount = totalAmount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingAddr() {
		return ShippingAddr;
	}
	public void setShippingAddr(String shippingAddr) {
		ShippingAddr = shippingAddr;
	}
	public String getTrans() {
		return Trans;
	}
	public void setTrans(String trans) {
		Trans = trans;
	}
	
}
