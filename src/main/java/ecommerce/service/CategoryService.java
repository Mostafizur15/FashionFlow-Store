package ecommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecommerce.DAO.CategoryDao;
import ecommerce.model.Category;
@Service
@Transactional
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	public boolean saveCategory(Category prdCategory) {
		return this.categoryDao.addCategory(prdCategory);
	}
	public boolean deleteCategory(Category prdCategory) {
		return this.categoryDao.deleteCategory(prdCategory);
	}
	public List<Category> getAllCategory(){
		return this.categoryDao.listOfCategories();
	}
	public Category getCategory(int categoryId) {
		Category prd = this.categoryDao.getCategory(categoryId);
		return prd;
	}
	public boolean updateCategory(Category prdCategory) {
		return this.categoryDao.updateCategory(prdCategory);
	}
	public int getCategoryId(String category) {
		return this.categoryDao.getCategoryId(category);
	}
}
