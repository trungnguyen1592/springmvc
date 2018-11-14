package trung.model;

import java.sql.Timestamp;

public class BillDTO {
	private int billId;
	private Timestamp date;
	
	
	public int getBillId() {
		return billId;
	}
	public void setBillId(int idOrder) {
		this.billId = idOrder;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
