package trung.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import trung.model.ProductDTO;

@Component
public class ProductValidator implements Validator{

	//kiem tra doi tuong truyen vao co phai User ko
	public boolean supports(Class<?> clazz) {
		return ProductDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ProductDTO product = (ProductDTO) target;
		if(product.getName() == null || product.getName().length() == 0) {
			errors.rejectValue("name", "field.required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category_id", "field.category.required");
	}

}
