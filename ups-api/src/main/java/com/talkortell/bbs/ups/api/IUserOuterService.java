package com.talkortell.bbs.ups.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talkortell.bbs.base.common.resp.BasePaginationResponse;
import com.talkortell.bbs.base.common.resp.BaseResponse;
import com.talkortell.bbs.ups.api.constant.ApiConstants;
import com.talkortell.bbs.ups.api.dto.UserFullInfoDTO;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoByUserIdRequest;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoListRequest;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoRequest;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;

@RequestMapping(ApiConstants.API_SERVICE_V1 + "/user/manager")
public interface IUserOuterService {
	
	@PostMapping("/userRegister")
	BaseResponse<String> userRegister(@RequestBody UserRegisterRequest userRegisterRequest);
	
	@PostMapping("/queryUserFullInfo")
	BaseResponse<UserFullInfoDTO> queryUserFullInfo(@RequestBody QueryUserFullInfoRequest queryUserFullInfoRequest);
	
	@PostMapping("/queryUserFullInfoByUserId")
	BaseResponse<UserFullInfoDTO> queryUserFullInfoByUserId(@RequestBody QueryUserFullInfoByUserIdRequest queryUserFullInfoByUserIdRequest);
	
	@PostMapping("/queryUserFullInfoList")
	BasePaginationResponse<UserFullInfoDTO> queryUserFullInfoList(@RequestBody QueryUserFullInfoListRequest queryUserFullInfoListRequest);
}
