package trung.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import trung.model.UserDTO;

@Component
public class UserValidator implements Validator{

	//kiem tra doi tuong truyen vao co phai User ko
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserDTO user = (UserDTO) target;
		if(user.getName() == null || user.getName().length() == 0) {
			errors.rejectValue("name", "field.required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required");
	}

}
