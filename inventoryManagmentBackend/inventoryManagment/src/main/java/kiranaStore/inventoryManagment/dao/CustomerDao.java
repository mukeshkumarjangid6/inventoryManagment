package kiranaStore.inventoryManagment.dao;

import java.util.List;

import kiranaStore.inventoryManagment.dto.Customer;

public interface CustomerDao {
	public Boolean add(Customer customer);

	public Boolean update(Customer customer);

	public Boolean delete(Integer customerId);

	public Customer searchById(Integer customerId);

	public List<Customer> customersList();
}