package com.talkortell.bbs.ups.service;

import com.talkortell.bbs.base.common.exception.AppLogicException;
import com.talkortell.bbs.domain.mysql.ups.po.UserFullInfo;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoRequest;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;

public interface IUserDAOService {
	public void addUser(UserRegisterRequest userRegisterRequest) throws AppLogicException;
	public UserFullInfo queryUserFullInfo(QueryUserFullInfoRequest queryUserFullInfoRequest) throws AppLogicException;
	public UserFullInfo queryUserFullInfoByUserId(String userId) throws AppLogicException;
}
