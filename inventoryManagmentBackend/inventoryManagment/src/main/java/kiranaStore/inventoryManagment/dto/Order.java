package kiranaStore.inventoryManagment.dto;

import java.sql.Timestamp;

public class Order {
	private Integer orderId;
	private Integer employeeId;
	private Integer customerId;
	private Integer productId;
	private Integer orderQuantity;
	private Timestamp orderDate;
	private Integer totalPrice;

	public Order() {

	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", employeeId=" + employeeId + ", customerId=" + customerId
				+ ", productId=" + productId + ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate
				+ ", totalPrice=" + totalPrice + "]";
	}
}