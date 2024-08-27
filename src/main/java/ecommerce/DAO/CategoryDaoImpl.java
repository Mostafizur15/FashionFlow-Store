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
import ecommerce.model.Category;

@Repository("categoryDao1")
@Transactional
public class CategoryDaoImpl implements CategoryDao {


	@Autowired
    private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

    @Override
    public boolean addCategory(Category prdCatagory) {
        try {
            hibernateTemplate.saveOrUpdate(prdCatagory);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Category prdCatagory) {
        try {
            hibernateTemplate.delete(prdCatagory);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCategory(Category prdCatagory) {
        try {
            hibernateTemplate.update(prdCatagory);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Category> listOfCategories() {
        try {
            return hibernateTemplate.loadAll(Category.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Category getCategory(int categoryId) {
        try {
        	Category cat = hibernateTemplate.load(Category.class, categoryId);
        	Hibernate.initialize(cat);
            return cat;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

	@Override
	public int getCategoryId(String category) {
		try {
			String hql = "from Category where categoryName = :catName";
			Map<String,Object>params=new HashMap<>();
        	params.put("catName", category);

			List<Category> cat = (List<Category>)hibernateTemplate.findByNamedParam(hql, new String[] {"catName"}, new Object[] {category});
        	if(cat.size()>0)return cat.get(0).getCategoryId();
            return -1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
	}
}
