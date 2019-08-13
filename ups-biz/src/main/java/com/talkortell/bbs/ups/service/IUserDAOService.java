package com.talkortell.bbs.ups.service;

import com.talkortell.bbs.base.common.exception.AppLogicException;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;

public interface IUserDAOService {
	public void addUser(UserRegisterRequest userRegisterRequest) throws AppLogicException;
	public void queryUserBase() throws AppLogicException;
}
