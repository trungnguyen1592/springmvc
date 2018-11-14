package trung.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.UserDao;
import trung.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}

	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(getUserById(id));
	}

	public User getUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public List<User> getAllUsers() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

}
