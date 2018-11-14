package trung.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.BillDetailDao;
import trung.entity.Billdetail;

@Repository
@Transactional
public class BillDetailDaoImpl implements BillDetailDao{

	@Autowired
	SessionFactory sessionFactory;
	public void addBillDetail(Billdetail billdetail) {
		sessionFactory.getCurrentSession().save(billdetail);
	}
}
