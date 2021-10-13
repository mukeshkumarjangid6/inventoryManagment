package kiranaStore.inventoryManagment.dao;

import java.util.List;

import kiranaStore.inventoryManagment.dto.Product;

public interface ProductDao {
	public Boolean add(Product product);

	public Boolean update(Product product);

	public Boolean delete(Integer productId);

	public Product searchById(Integer productId);

	public List<Product> productsList();
}