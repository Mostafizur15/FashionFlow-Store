package ecommerce.DAO;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import ecommerce.model.OrderDetail;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
    private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public boolean saveOrder(OrderDetail order) {
		try {
            hibernateTemplate.save(order);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
		
	}

	@Override
	public boolean updateCart(String userName) {
		Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
		Query<?> qry=session.createQuery("UPDATE CartItem SET paymentStatus='p' WHERE userName=:name");
		qry.setParameter("name", userName);
		int row=qry.executeUpdate();
		return row>0?true:false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
