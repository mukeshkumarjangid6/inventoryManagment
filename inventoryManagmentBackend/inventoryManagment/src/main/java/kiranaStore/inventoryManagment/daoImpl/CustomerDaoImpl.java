package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.inventoryManagment.dao.CustomerDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private DbConfig dbConfig;
	private PreparedStatement stmt;

	public CustomerDaoImpl() {
		dbConfig = DbConfig.getDbConfig();
	}

	@Override
	public Boolean add(Customer customer) {
		try {
			stmt = dbConfig.getCon().prepareStatement(
					"INSERT INTO Customer (customerId, customerName,customerphone, customerage)VALUES (?,?,?,?);");
			stmt.setInt(1, customer.getCustomerId());
			stmt.setString(2, customer.getCustomerName());
			stmt.setString(3, customer.getCustomerphone());
			stmt.setInt(4, customer.getCustomerage());

			int i = stmt.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean update(Customer customer) {
		try {
			stmt = dbConfig.getCon().prepareStatement(
					"UPDATE Customer SET customerName=?,customerphone=?, customerage=? WHERE customerId=?");
			stmt.setString(1, customer.getCustomerName());
			stmt.setString(2, customer.getCustomerphone());
			stmt.setInt(3, customer.getCustomerage());
			stmt.setInt(4, customer.getCustomerId());

			int i = stmt.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean delete(Integer customerId) {

		try {
			stmt = dbConfig.getCon().prepareStatement("delete from customer where customerid=" + customerId);
			int n = stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer searchById(Integer customerId) {
		ResultSet rs = null;
		Customer customer = null;
		try {
			stmt = dbConfig.getCon().prepareStatement("select * from Customer where customerId=" + customerId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerphone(rs.getString("customerphone"));
				customer.setCustomerage(rs.getInt("customerage"));
				return customer;
			}
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Customer> customersList() {
		ResultSet rs = null;
		Customer customer = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			stmt = dbConfig.getCon().prepareStatement("select * from Customer");
			rs = stmt.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerphone(rs.getString("customerphone"));
				customer.setCustomerage(rs.getInt("customerage"));
				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}