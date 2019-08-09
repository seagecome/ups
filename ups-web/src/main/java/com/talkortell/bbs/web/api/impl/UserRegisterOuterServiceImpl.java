package com.talkortell.bbs.web.api.impl;

import org.springframework.web.bind.annotation.RestController;

import com.talkortell.bbs.base.common.resp.BaseResponse;
import com.talkortell.bbs.ups.api.IUserRegisterOuterService;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;

@RestController
public class UserRegisterOuterServiceImpl implements IUserRegisterOuterService {

	@Override
	public BaseResponse<String> userRegister(UserRegisterRequest userRegisterRequest) {
		return null;
	}

}
