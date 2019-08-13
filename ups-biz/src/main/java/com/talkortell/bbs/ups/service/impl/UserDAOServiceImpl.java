package com.talkortell.bbs.ups.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.talkortell.bbs.dal.dao.ups.mysql.master.UserBaseInfoMapper;
import com.talkortell.bbs.dal.dao.ups.mysql.master.UserOperInfoMapper;
import com.talkortell.bbs.dal.dao.ups.mysql.slave.UserBaseInfoSlaveMapper;
import com.talkortell.bbs.base.common.exception.AppLogicException;
import com.talkortell.bbs.dal.config.master.MasterUpsDataSourceConfig;
import com.talkortell.bbs.domain.mysql.ups.UserBaseInfo;
import com.talkortell.bbs.domain.mysql.ups.UserBaseInfoCriteria;
import com.talkortell.bbs.domain.mysql.ups.UserOperInfo;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;
import com.talkortell.bbs.ups.service.IUserDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("userDAOService")
public class UserDAOServiceImpl implements IUserDAOService {

	@Autowired
	private UserBaseInfoMapper userBaseInfoMapper;
	@Autowired
	private UserBaseInfoSlaveMapper userBaseInfoSlaveMapper;
	@Autowired
	private UserOperInfoMapper userOperInfoMapper;
	
	@Transactional(value=MasterUpsDataSourceConfig.TRANS_MANAGER, rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	@Override
	public void addUser(UserRegisterRequest userRegisterRequest) throws AppLogicException {
		Date currentTime = new Date();
		UserBaseInfo ubi = new UserBaseInfo();
		ubi.setLoginAccount(userRegisterRequest.getUserEmail());
		ubi.setLoginPassword(userRegisterRequest.getLoginPassword());
		ubi.setCreateTime(currentTime);
		ubi.setUpdateTime(currentTime);
		int ubiCount = userBaseInfoMapper.insertSelective(ubi);
		if(ubiCount <= 0) {
			throw new AppLogicException("insert userbaseinfo error");
		}
		
		UserOperInfo uoi = new UserOperInfo();
		uoi.setUserEmail(userRegisterRequest.getUserEmail());
		uoi.setUserKey(ubi.getId());
		uoi.setCreateTime(currentTime);
		uoi.setUpdateTime(currentTime);
		int uoiCount = userOperInfoMapper.insertSelective(uoi);
		if(uoiCount <= 0) {
			throw new AppLogicException("insert useroperinfo error");
		}
		
	}

	@Override
	public void queryUserBase() throws AppLogicException {
		UserBaseInfo ubi = userBaseInfoSlaveMapper.selectByPrimaryKey(2l);
		log.info("===ubi==={}", ubi);
		ubi.setLoginPassword("wolaile");
		UserBaseInfoCriteria criteria = new UserBaseInfoCriteria();
		criteria.createCriteria().andIdEqualTo(2l);
		userBaseInfoMapper.updateByCriteriaSelective(ubi, criteria);
	}

}
