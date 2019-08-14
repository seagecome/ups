package com.talkortell.bbs.dal.dao.ups.mysql.slave;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.talkortell.bbs.domain.mysql.ups.po.UserFullInfo;

public interface UserFullInfoMySlaveMapper {
	UserFullInfo queryUserFullInfo(Map<String, Object> paramMap);
	UserFullInfo queryUserFullInfoByUserId(@Param("userId") String userId);
}