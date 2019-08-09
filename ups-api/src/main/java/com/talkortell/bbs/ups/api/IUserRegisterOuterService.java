package com.talkortell.bbs.ups.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talkortell.bbs.base.common.resp.BaseResponse;
import com.talkortell.bbs.ups.api.constant.ApiConstants;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;

@RequestMapping(ApiConstants.API_SERVICE_V1 + "/user/manager")
public interface IUserRegisterOuterService {
	
	@PostMapping("/userRegister")
	BaseResponse<String> userRegister(UserRegisterRequest userRegisterRequest);
}
