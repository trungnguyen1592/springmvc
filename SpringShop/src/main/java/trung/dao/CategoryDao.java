package trung.dao;

import java.util.List;

import trung.entity.Category;

public interface CategoryDao {
	public void addCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void deleteCategory(int id);
	
	public Category getCategoryById(int id);
	
	public List<Category> getAllCategories();
}
