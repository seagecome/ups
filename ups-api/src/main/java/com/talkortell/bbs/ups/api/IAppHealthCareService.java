package com.talkortell.bbs.ups.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talkortell.bbs.base.common.resp.BaseResponse;
import com.talkortell.bbs.ups.api.constant.ApiConstants;

@RequestMapping(ApiConstants.API_SERVICE_V1 + "/health")
public interface IAppHealthCareService {
	@GetMapping("/show")
	BaseResponse<String> showBootState();
}
