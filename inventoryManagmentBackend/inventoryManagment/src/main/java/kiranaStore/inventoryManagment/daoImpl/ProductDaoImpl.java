package kiranaStore.inventoryManagment.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kiranaStore.inventoryManagment.dao.ProductDao;
import kiranaStore.inventoryManagment.databaseConfig.DbConfig;
import kiranaStore.inventoryManagment.dto.Product;

public class ProductDaoImpl implements ProductDao {
	private DbConfig dbConfig;
	private PreparedStatement stmt;

	public ProductDaoImpl() {
		dbConfig = DbConfig.getDbConfig();
	}

	@Override
	public Boolean add(Product product) {
		try {
			stmt = dbConfig.getCon().prepareStatement(
					"INSERT INTO Product (productId, productName,productPrice, productAvailability)VALUES (?,?,?,?);");
			stmt.setInt(1, product.getProductId());
			stmt.setString(2, product.getProductName());
			stmt.setInt(3, product.getProductPrice());
			stmt.setInt(4, product.getProductAvailability());

			int i = stmt.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean update(Product product) {
		try {

			stmt = dbConfig.getCon().prepareStatement(
					"UPDATE Product SET productName=?,productPrice=?, productAvailability=? WHERE productId=?");
			stmt.setInt(4, product.getProductId());
			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getProductPrice());
			stmt.setInt(3, product.getProductAvailability());

			int i = stmt.executeUpdate();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean delete(Integer productId) {
		try {
			stmt = dbConfig.getCon().prepareStatement("delete from Product where productId = " + productId);
			int n = stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product searchById(Integer productId) {
		ResultSet rs = null;
		Product product = null;
		try {
			stmt = dbConfig.getCon().prepareStatement("select * from Product where productId=" + productId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductAvailability(rs.getInt("productAvailability"));
				return product;
			}
			return product;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> productsList() {
		ResultSet rs = null;
		Product product = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			stmt = dbConfig.getCon().prepareStatement("select * from Product");
			rs = stmt.executeQuery();
			while (rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductAvailability(rs.getInt("productAvailability"));
			}
			return productList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
