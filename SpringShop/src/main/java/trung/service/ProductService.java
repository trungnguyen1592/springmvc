package trung.service;

import java.util.List;

import trung.entity.Product;
import trung.model.ProductDTO;

public interface ProductService {
	public void addProduct(ProductDTO product);

	public void updateProduct(ProductDTO product);

	public void deleteProduct(int id);

	public ProductDTO getProductById(int id);

	public List<ProductDTO> getAllProducts();
	
	public List<ProductDTO> getAllProductsById(int category_Id);
}
