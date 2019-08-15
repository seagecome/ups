package com.talkortell.bbs.web.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.talkortell.bbs.base.common.resp.BasePaginationResponse;
import com.talkortell.bbs.base.common.resp.BaseResponse;
import com.talkortell.bbs.base.common.service.ServiceHandler;
import com.talkortell.bbs.ups.api.IUserOuterService;
import com.talkortell.bbs.ups.api.dto.UserFullInfoDTO;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoByUserIdRequest;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoListRequest;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoRequest;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;
import com.talkortell.bbs.ups.service.IUserDAOService;
import com.talkortell.bbs.web.api.validator.QueryUserInfoRequestV;
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
	public BaseResponse<UserFullInfoDTO> queryUserFullInfo(QueryUserFullInfoRequest queryUserFullInfoRequest) {
		return ServiceHandler.call(queryUserFullInfoRequest, QueryUserInfoRequestV.class, UserFullInfoDTO.class, (req) -> {
			return userDAOService.queryUserFullInfo(queryUserFullInfoRequest);
		});
	}

	@Override
	public BaseResponse<UserFullInfoDTO> queryUserFullInfoByUserId(QueryUserFullInfoByUserIdRequest queryUserFullInfoByUserIdRequest) {
		return ServiceHandler.call(queryUserFullInfoByUserIdRequest, null, UserFullInfoDTO.class, (req) -> {
			return userDAOService.queryUserFullInfoByUserId(queryUserFullInfoByUserIdRequest.getUserId());
		});
	}

	@Override
	public BasePaginationResponse<UserFullInfoDTO> queryUserFullInfoList(QueryUserFullInfoListRequest queryUserFullInfoListRequest) {
		return ServiceHandler.callList(queryUserFullInfoListRequest, null, UserFullInfoDTO.class, (req, page) -> {
			return userDAOService.queryUserFullInfoList(queryUserFullInfoListRequest.getUserIds(), page);
		});
	}
}
