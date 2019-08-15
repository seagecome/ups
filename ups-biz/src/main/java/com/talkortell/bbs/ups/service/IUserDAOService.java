package com.talkortell.bbs.ups.service;

import java.util.List;

import com.talkortell.bbs.base.common.exception.AppLogicException;
import com.talkortell.bbs.base.common.page.TotPage;
import com.talkortell.bbs.domain.mysql.ups.po.UserFullInfo;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoRequest;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;

public interface IUserDAOService {
	void addUser(UserRegisterRequest userRegisterRequest) throws AppLogicException;
	UserFullInfo queryUserFullInfo(QueryUserFullInfoRequest queryUserFullInfoRequest) throws AppLogicException;
	UserFullInfo queryUserFullInfoByUserId(String userId) throws AppLogicException;
	List<UserFullInfo> queryUserFullInfoList(List<String> userIds, TotPage page) throws AppLogicException;
}
