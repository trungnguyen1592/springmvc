package trung.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CategoryDTO {
	private int category_id;
	private String name;
	private String thumbnail;
	private MultipartFile file;
	private List<ProductDTO> productDTO;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public List<ProductDTO> getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(List<ProductDTO> productDTO) {
		this.productDTO = productDTO;
	}

}
