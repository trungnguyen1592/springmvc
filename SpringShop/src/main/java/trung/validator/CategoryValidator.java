package trung.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import trung.model.CategoryDTO;

@Component
public class CategoryValidator implements Validator{

	//kiem tra doi tuong truyen vao co phai User ko
	public boolean supports(Class<?> clazz) {
		return CategoryDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CategoryDTO category = (CategoryDTO) target;
		if(category.getName() == null || category.getName().length() == 0) {
			errors.rejectValue("name", "field.required");
		}
	}

}
