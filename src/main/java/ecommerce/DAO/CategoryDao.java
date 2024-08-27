package ecommerce.DAO;
import java.util.List;

import ecommerce.model.Category;
public interface CategoryDao {
	public boolean addCategory(Category prdCatagory);
	public boolean deleteCategory(Category prdCatagory);
	public boolean updateCategory(Category prdCatagory);
	public int getCategoryId(String category);
	public List<Category> listOfCategories();
	public Category getCategory(int categoryId);
}
