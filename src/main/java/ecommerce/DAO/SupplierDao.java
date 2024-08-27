package ecommerce.DAO;

import java.util.List;

import ecommerce.model.Supplier;

public interface SupplierDao {
	public boolean addSupplier(Supplier prdSupplier);
	public boolean deleteSupplier(Supplier prdSupplier);
	public boolean updateSupplier(Supplier prdSupplier);
	public List<Supplier> listOfCategories();
	public Supplier getSupplier(int supplierId);
}
