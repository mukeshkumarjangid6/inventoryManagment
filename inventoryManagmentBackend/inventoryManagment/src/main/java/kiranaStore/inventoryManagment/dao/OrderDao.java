package kiranaStore.inventoryManagment.dao;

import kiranaStore.inventoryManagment.dto.Order;

public interface OrderDao {
	public Boolean add(Order order);

	public Boolean update(Order order);

	public Boolean delete(Integer orderId);

	public Order searchById(Integer orderId);
}