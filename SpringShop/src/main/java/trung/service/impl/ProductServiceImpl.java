package trung.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trung.dao.ProductDao;
import trung.entity.Product;
import trung.model.CategoryDTO;
import trung.model.ProductDTO;
import trung.service.CategoryService;
import trung.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;

	public void addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setCategory_id(productDTO.getCategory_id());
		product.setPrice(productDTO.getPrice());
		product.setImageUrl(productDTO.getImageUrl());
		productDao.addProduct(product);
	}

	public void updateProduct(ProductDTO productDTO) {
		Product product = productDao.getProductById(productDTO.getId());
		if(product != null) {
			product.setName(productDTO.getName());
			product.setPrice(productDTO.getPrice());
			product.setCategory_id(productDTO.getCategory_id());
			product.setImageUrl(productDTO.getImageUrl());
			productDao.updateProduct(product);
		}
	}

	public void deleteProduct(int id) {
		Product product = productDao.getProductById(id);
		if(product != null) {
			productDao.deleteProduct(id);
		}
	}

	public ProductDTO getProductById(int id) {
		Product product = productDao.getProductById(id);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setCategory_id(product.getCategory_id());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setImageUrl(product.getImageUrl());
		return productDTO;
	}
	@Autowired
	CategoryService categoryService; 

	public List<ProductDTO> getAllProducts() {
		List<Product> products = productDao.getAllProducts();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for(Product product: products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setCategory_id(product.getCategory_id());
			productDTO.setName(product.getName());
			productDTO.setPrice(product.getPrice());
			CategoryDTO categories = categoryService.getCategoryById(product.getCategory_id());
			productDTO.setCategoryDTO(categories);
			productDTOs.add(productDTO);
		}
		
		return productDTOs;
	}
	
	public List<ProductDTO> getAllProductsById(int category_id) {
		List<Product> products = productDao.getAllProductsById(category_id);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		for(Product product: products) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setCategory_id(product.getCategory_id());
			productDTO.setName(product.getName());
			productDTO.setImageUrl(product.getImageUrl());
			productDTO.setPrice(product.getPrice());
			CategoryDTO categories = categoryService.getCategoryById(product.getCategory_id());
			productDTO.setCategoryDTO(categories);
			productDTOs.add(productDTO);
		}
		
		return productDTOs;
	}
}
