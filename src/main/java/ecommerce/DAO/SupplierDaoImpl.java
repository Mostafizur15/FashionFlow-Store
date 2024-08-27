package ecommerce.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ecommerce.model.Supplier;
@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao{
	@Autowired
    private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public boolean addSupplier(Supplier prdSupplier) {
		try {
			this.hibernateTemplate.save(prdSupplier);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier prdSupplier) {
		try {
			this.hibernateTemplate.delete(prdSupplier);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier prdSupplier) {
		try {
			this.hibernateTemplate.update(prdSupplier);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Supplier> listOfCategories() {
		try {
			return this.hibernateTemplate.loadAll(Supplier.class);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		try {
			return this.hibernateTemplate.load(Supplier.class, supplierId);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
