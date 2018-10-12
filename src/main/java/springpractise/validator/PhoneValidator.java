package springpractise.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;


public class PhoneValidator implements ConstraintValidator<Phone, String>{
	
	public void initialize(Phone arg0) {
		
	}

	public boolean isValid(String phone, ConstraintValidatorContext ctx) {
		if (null == phone)
			return false;
		String regex = "^\\+(?:[0-9]?){6,14}[0-9]$";
		if (phone.matches("\\d{10}")){
			if (phone.trim().length() > 10 || !phone.startsWith("0"))
				return false;
		}else if (phone.matches(regex)){
			if(phone.trim().length() > 12)
				return false;
		}else{
			return false;
		}
		return true;
	}
}
