package com.talkortell.bbs.ups.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.talkortell.bbs.base.common.exception.AppLogicException;
import com.talkortell.bbs.base.common.page.TotPage;
import com.talkortell.bbs.dal.config.master.MasterUpsDataSourceConfig;
import com.talkortell.bbs.dal.dao.ups.mysql.master.UserBaseInfoMapper;
import com.talkortell.bbs.dal.dao.ups.mysql.master.UserOperInfoMapper;
import com.talkortell.bbs.dal.dao.ups.mysql.slave.UserFullInfoMySlaveMapper;
import com.talkortell.bbs.domain.mysql.ups.UserBaseInfo;
import com.talkortell.bbs.domain.mysql.ups.UserOperInfo;
import com.talkortell.bbs.domain.mysql.ups.po.UserFullInfo;
import com.talkortell.bbs.ups.api.dto.req.QueryUserFullInfoRequest;
import com.talkortell.bbs.ups.api.dto.req.UserRegisterRequest;
import com.talkortell.bbs.ups.service.IUserDAOService;
import com.talkortell.bbs.utils.SnowflakeIdWorker;

@Service("userDAOService")
public class UserDAOServiceImpl implements IUserDAOService {

	@Autowired
	private UserBaseInfoMapper userBaseInfoMapper;
	@Autowired
	private UserOperInfoMapper userOperInfoMapper;
	@Autowired
	private UserFullInfoMySlaveMapper userFullInfoMySlaveMapper;
	
	@Transactional(value=MasterUpsDataSourceConfig.TRANS_MANAGER, rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	@Override
	public void addUser(UserRegisterRequest userRegisterRequest) throws AppLogicException {
		Date currentTime = new Date();
		UserBaseInfo ubi = new UserBaseInfo();
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
		ubi.setUserId(String.valueOf(idWorker.nextId()));
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
	public UserFullInfo queryUserFullInfo(QueryUserFullInfoRequest queryUserFullInfoRequest) throws AppLogicException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginAccount", queryUserFullInfoRequest.getLoginAccount());
		paramMap.put("userEmail", queryUserFullInfoRequest.getUserEmail());
		paramMap.put("userMobile", queryUserFullInfoRequest.getUserMobile());
		return userFullInfoMySlaveMapper.queryUserFullInfo(paramMap);
	}

	@Override
	public UserFullInfo queryUserFullInfoByUserId(String userId) throws AppLogicException {
		if(StringUtils.isBlank(userId)) {
			throw new AppLogicException("参数不能为空");
		}
		return userFullInfoMySlaveMapper.queryUserFullInfoByUserId(userId);
	}

	@Override
	public List<UserFullInfo> queryUserFullInfoList(List<String> userIds, TotPage page) throws AppLogicException {
		if(CollectionUtils.isEmpty(userIds)) {
			throw new AppLogicException("参数不能为空");
		}
		PageHelper.startPage(page.getPageNo(), page.getLength());
		List<UserFullInfo>  ufiList = userFullInfoMySlaveMapper.queryUserFullInfoList(userIds);
		PageInfo<UserFullInfo> pageInfo = new PageInfo<UserFullInfo>(ufiList);
		page.setTotalRecords(pageInfo.getTotal());
		
		return ufiList;
	}

}
