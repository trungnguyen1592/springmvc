package trung.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.BillDetailDao;
import trung.entity.Billdetail;
import trung.model.BillDetailDTO;
import trung.service.BillDetailService;

@Service
@Transactional
public class BillDetailServiceImpl implements BillDetailService{
	
	@Autowired
	BillDetailDao billDetailDao;

	public void addBillDetail(BillDetailDTO billDetailDTO, int orderDetailId) {
		Billdetail billdetail = new Billdetail();
		billdetail.setBillDetailId(billDetailDTO.getBillDetailId());
		billdetail.setBillId(orderDetailId);
		billdetail.setPrice(billDetailDTO.getPrice());
		billdetail.setProductId(billDetailDTO.getProductId());
		billdetail.setQuantity(billDetailDTO.getQuantity());
		billDetailDao.addBillDetail(billdetail);
	}

}
