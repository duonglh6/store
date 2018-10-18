package com.hp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hp.model.UserDTO;

@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserDTO user = (UserDTO) target;
		if(user.getName()==null || user.getName().length()==0){
			errors.rejectValue("name", "field.required");
			
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "field.required");
		
		
	}

}
