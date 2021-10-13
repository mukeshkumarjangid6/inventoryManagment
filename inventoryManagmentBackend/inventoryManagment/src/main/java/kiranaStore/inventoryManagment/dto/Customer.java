package kiranaStore.inventoryManagment.dto;

public class Customer {
	private Integer customerId;
	private String customerName;
	private String customerphone;
	private Integer customerage;

	public Customer() {

	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerphone() {
		return customerphone;
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	public Integer getCustomerage() {
		return customerage;
	}

	public void setCustomerage(Integer customerage) {
		this.customerage = customerage;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerphone="
				+ customerphone + ", customerage=" + customerage + "]";
	}

}