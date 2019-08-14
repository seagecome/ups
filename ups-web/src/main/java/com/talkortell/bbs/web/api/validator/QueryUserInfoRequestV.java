package com.talkortell.bbs.web.api.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.talkortell.bbs.base.common.validator.IValidator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryUserInfoRequestV implements IValidator {

	private String loginAccount;
	private String userEmail;
	private String userMobile;
	
	@Override
	public void selfValidate(List<String> errors, Integer useCase) {
		if(StringUtils.isBlank(loginAccount) &&
				StringUtils.isBlank(userEmail) &&
				StringUtils.isBlank(userMobile)) {
			errors.add("参数不能为空");
		}
	}

}
