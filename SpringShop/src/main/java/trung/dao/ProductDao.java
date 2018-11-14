package trung.dao;

import java.util.List;

import trung.entity.Product;

public interface ProductDao {
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int id);
	
	public Product getProductById(int id);
	
	public List<Product> getAllProducts();
	
	public List<Product> getAllProductsById(int category_id);
}
