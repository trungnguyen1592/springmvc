package trung.service;

import trung.model.BillDetailDTO;

public interface BillDetailService {
	public void addBillDetail(BillDetailDTO billDetailDTO, int orderDetailId);
}
