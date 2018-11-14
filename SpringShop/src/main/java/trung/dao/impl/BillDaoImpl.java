package trung.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.BillDao;
import trung.entity.Bill;

@Repository
@Transactional
public class BillDaoImpl implements BillDao{

	@Autowired
	SessionFactory sessionFactory;
	public void addBill(Bill bill) {
		sessionFactory.getCurrentSession().save(bill);
	}
}
