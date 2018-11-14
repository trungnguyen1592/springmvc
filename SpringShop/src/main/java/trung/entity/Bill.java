package trung.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bill_id")
	private int billId;

	private Timestamp date;

	public Bill() {
	}

	public int getBillId() {
		return this.billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}