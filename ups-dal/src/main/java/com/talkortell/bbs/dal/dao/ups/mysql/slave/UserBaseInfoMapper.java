package com.talkortell.bbs.dal.dao.ups.mysql.slave;

import com.talkortell.bbs.dal.dao.ups.base.SelfMySQLSlaveMapper;
import com.talkortell.bbs.domain.mysql.ups.UserBaseInfo;
import com.talkortell.bbs.domain.mysql.ups.UserBaseInfoCriteria;
import java.util.List;

public interface UserBaseInfoMapper extends SelfMySQLSlaveMapper<UserBaseInfo> {
    long countByCriteria(UserBaseInfoCriteria criteria);

    List<UserBaseInfo> selectByCriteria(UserBaseInfoCriteria criteria);
}