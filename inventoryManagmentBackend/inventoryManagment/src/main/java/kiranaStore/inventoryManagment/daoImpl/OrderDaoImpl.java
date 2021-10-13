package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import kiranaStore.inventoryManagment.dao.OrderDao;
import kiranaStore.inventoryManagment.dao.ProductDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Order;
import kiranaStore.inventoryManagment.dto.Product;

public class OrderDaoImpl implements OrderDao {
	private DbConfig dbConfig;
	private PreparedStatement stmt;
	private ProductDao productDao;

	public OrderDaoImpl() {
		dbConfig = DbConfig.getDbConfig();
		productDao = new ProductDaoImpl();
	}

	@Override
	public Boolean add(Order order) {
		try {
			stmt = dbConfig.getCon().prepareStatement(
					"INSERT INTO Order1 (orderId, employeeId,customerId, productId, orderQuantity, orderDate, totalPrice)VALUES (?,?,?,?,?,?,?);");
			Integer orderId = order.getOrderId();
			Integer employeeId = order.getEmployeeId();
			Integer customerId = order.getCustomerId();
			Integer productId = order.getProductId();
			Integer orderQuantity = order.getOrderQuantity();
			Timestamp orderDate = new Timestamp(new Date().getTime());
			Integer totalPrice = order.getTotalPrice();

			Product product = productDao.searchById(productId);
			if (product.getProductAvailability() < orderQuantity) {
				throw new ArithmeticException("We do not have enough quantity of " + product.getProductName()
						+ ". We have only " + product.getProductAvailability());
			}
			if (totalPrice <= 0 || totalPrice == null) {
				throw new NullPointerException("You must buy atleast one Product");
			}

			stmt.setInt(1, orderId);
			stmt.setInt(2, employeeId);
			stmt.setInt(3, customerId);
			stmt.setInt(4, productId);
			stmt.setInt(5, orderQuantity);
			stmt.setTimestamp(6, orderDate);
			stmt.setInt(7, totalPrice);

			int i = stmt.executeUpdate();

			stmt = null;
			stmt = dbConfig.getCon().prepareStatement("UPDATE Product SET productAvailability=? WHERE productId=?");
			Integer remainingQty = product.getProductAvailability() - orderQuantity;
			stmt.setInt(1, remainingQty);
			stmt.setInt(2, product.getProductId());

			i = stmt.executeUpdate();

			return true;
		} catch (SQLException | ArithmeticException | NullPointerException e1) {
			System.out.println(e1);
			return false;
		}
	}

	@Override
	public Boolean update(Order order) {

		return null;
	}

	@Override
	public Boolean delete(Integer orderId) {

		return null;
	}

	@Override
	public Order searchById(Integer orderId) {

		return null;
	}

}