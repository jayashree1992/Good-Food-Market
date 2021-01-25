package com.neu.edu.webtools.project.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.edu.webtools.project.backend.dto.Item;

public class ValidatingItem implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Item item = (Item) target;
		if(item.getFile() == null || item.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		if(! (item.getFile().getContentType().equals("image/jpeg") || 
				item.getFile().getContentType().equals("image/png")) ||
				item.getFile().getContentType().equals("image/gif")
			 )
			{
				errors.rejectValue("file", null, "Please select an image file to upload!");
				return;	
			}

	}
	
}
