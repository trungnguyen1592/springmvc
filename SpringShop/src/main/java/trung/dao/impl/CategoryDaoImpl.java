package trung.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.CategoryDao;
import trung.entity.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;
	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	public void updateCategory(Category category) {
		sessionFactory.getCurrentSession().merge(category);
	}

	public void deleteCategory(int id) {
		sessionFactory.getCurrentSession().delete(getCategoryById(id));
	}

	public Category getCategoryById(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	public List<Category> getAllCategories() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		return criteria.list();
	}

}
