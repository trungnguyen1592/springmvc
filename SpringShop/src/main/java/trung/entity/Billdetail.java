package trung.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the billdetail database table.
 * 
 */
@Entity
public class Billdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_detail_id")
	private int billDetailId;

	@Column(name="bill_id")
	private int billId;

	private String price;

	@Column(name="product_id")
	private int productId;

	private int quantity;

	public Billdetail() {
	}

	public int getBillDetailId() {
		return this.billDetailId;
	}

	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}

	public int getBillId() {
		return this.billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}