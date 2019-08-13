package com.talkortell.bbs.web.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.talkortell.bbs.base.common.resp.BaseResponse;
import com.talkortell.bbs.base.common.service.ServiceHandler;
import com.talkortell.bbs.ups.api.IUserOuterService;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;
import com.talkortell.bbs.ups.service.IUserDAOService;
import com.talkortell.bbs.web.api.validator.UserRegisterRequestV;

@RestController
public class UserRegisterOuterServiceImpl implements IUserOuterService {

	@Autowired
	private IUserDAOService userDAOService;
	
	@Override
	public BaseResponse<String> userRegister(UserRegisterRequest userRegisterRequest) {
		return ServiceHandler.call(userRegisterRequest, UserRegisterRequestV.class, String.class, (req) -> {
			userDAOService.addUser(userRegisterRequest);
			return "success";
		});
	}

	@Override
	public BaseResponse<String> queryUserBase(UserRegisterRequest userRegisterRequest) {
		return ServiceHandler.call(userRegisterRequest, UserRegisterRequestV.class, String.class, (req) -> {
			userDAOService.queryUserBase();
			return "success";
		});
	}

}
