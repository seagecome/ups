package com.talkortell.bbs.web.api.validator;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.talkortell.bbs.base.common.validator.IValidator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequestV implements IValidator {

	@NotBlank
	private String userEmail;
	@NotBlank
	private String loginPassword;
	
	@Override
	public void selfValidate(List<String> errors, Integer useCase) {
		
	}

}
