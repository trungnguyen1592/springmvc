package trung.model;

import java.util.List;

public class OrderDTO {

	private int billId;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	private List<OrderItemDTO> itemDTOs;

	public List<OrderItemDTO> getItemDTOs() {
		return itemDTOs;
	}

	public void setItemDTOs(List<OrderItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}

}
