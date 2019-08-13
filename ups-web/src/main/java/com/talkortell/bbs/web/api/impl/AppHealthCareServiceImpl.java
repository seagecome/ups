package com.talkortell.bbs.web.api.impl;

import org.springframework.web.bind.annotation.RestController;

import com.talkortell.bbs.base.common.resp.BaseResponse;
import com.talkortell.bbs.base.common.service.ServiceHandler;
import com.talkortell.bbs.ups.api.IAppHealthCareService;

@RestController
public class AppHealthCareServiceImpl implements IAppHealthCareService {

	@Override
	public BaseResponse<String> showBootState() {
		return ServiceHandler.call(null, null, String.class, (p)->{
			return "boot success";
		});
	}

}
