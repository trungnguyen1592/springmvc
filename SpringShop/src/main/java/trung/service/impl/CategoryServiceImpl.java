package trung.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.CategoryDao;
import trung.entity.Category;
import trung.model.CategoryDTO;
import trung.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;

	public void addCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category.setThumbNail(categoryDTO.getThumbnail());
		categoryDao.addCategory(category);
	}

	public void updateCategory(CategoryDTO categoryDTO) {
		Category category = categoryDao.getCategoryById(categoryDTO.getCategory_id());
		if(category != null) {
			category.setName(categoryDTO.getName());
			category.setThumbNail(categoryDTO.getThumbnail());
			categoryDao.updateCategory(category);
		}
	}

	public void deleteCategory(int id) {
		Category category = categoryDao.getCategoryById(id);
		if(category != null) {
			categoryDao.deleteCategory(id);
		}
	}

	public CategoryDTO getCategoryById(int id) {
		Category category = categoryDao.getCategoryById(id);
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategory_id(category.getCategoryId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}

	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = categoryDao.getAllCategories();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		for(Category category: categories) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategory_id(category.getCategoryId());
			categoryDTO.setName(category.getName());
			categoryDTO.setThumbnail(category.getThumbNail());
			
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}
}
