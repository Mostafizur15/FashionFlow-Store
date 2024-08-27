package ecommerce.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import ecommerce.model.CartItem;
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao{
	@Autowired
    private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public boolean addCart(CartItem cart) {
		try {
            hibernateTemplate.saveOrUpdate(cart);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean deleteCart(CartItem cart) {
		try {
            hibernateTemplate.delete(cart);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean updateCart(CartItem cart) {
		try {
            hibernateTemplate.update(cart);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
	}

	@Override
	@Transactional
	public List<CartItem> listOfCart(String userName) {
        try {
            String hql = "from CartItem where userName = :userName and paymentStatus = :paymentStatus";
            // Create a map for named parameters
            Map<String, Object> params = new HashMap<>();
            params.put("userName", userName);
            params.put("paymentStatus", "NP");
            List<CartItem> result = (List<CartItem>) hibernateTemplate.findByNamedParam(hql, new String[]{"userName", "paymentStatus"}, new Object[]{userName, "NP"});
            
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


	@Override
	public CartItem getCart(int cartId) {
		try {
			CartItem cart = hibernateTemplate.load(CartItem.class, cartId);
        	Hibernate.initialize(cart);
            return cart;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}

}
