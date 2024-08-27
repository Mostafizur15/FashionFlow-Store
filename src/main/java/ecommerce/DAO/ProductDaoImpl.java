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
import ecommerce.model.Product;
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean addProduct(Product prod) {
		try {
			this.hibernateTemplate.saveOrUpdate(prod);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product prod) {
		try {
			this.hibernateTemplate.delete(prod);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product prod) {
		try {
			this.hibernateTemplate.update(prod);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listOfProduct() {
		try {
			return this.hibernateTemplate.loadAll(Product.class);
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public Product getProduct(int prodId) {
		try {
			Product prd=this.hibernateTemplate.load(Product.class, prodId);
			Hibernate.initialize(prd);
			return prd;
		}catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<Product> listOfProductBasedOnCategoryId(int categoryId) {
		try {
            String hql = "from Product where categoryId = :catId";
            // Create a map for named parameters
            Map<String, Object> params = new HashMap<>();
            params.put("catId", categoryId);
            List<Product> result = (List<Product>) hibernateTemplate.findByNamedParam(hql, new String[]{"catId"}, new Object[]{categoryId});
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
	}


}
