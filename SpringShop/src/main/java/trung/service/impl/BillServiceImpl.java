package trung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.BillDao;
import trung.entity.Bill;
import trung.model.BillDTO;
import trung.service.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillDao billDao;

	public void addBill(BillDTO billDTO) {
		Bill bill = new Bill();
		bill.setBillId(billDTO.getBillId());
		bill.setDate(billDTO.getDate());
		billDao.addBill(bill);
	}

}
