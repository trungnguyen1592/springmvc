package trung.service;

import java.util.List;

import trung.model.CategoryDTO;

public interface CategoryService {
	public void addCategory(CategoryDTO category);

	public void updateCategory(CategoryDTO category);

	public void deleteCategory(int id);

	public CategoryDTO getCategoryById(int id);

	public List<CategoryDTO> getAllCategories();
}
