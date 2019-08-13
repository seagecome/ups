package com.talkortell.bbs.dal.dao.ups.mysql.slave;

import com.talkortell.bbs.dal.dao.ups.base.SelfMySQLSlaveMapper;
import com.talkortell.bbs.domain.mysql.ups.UserOperInfo;
import com.talkortell.bbs.domain.mysql.ups.UserOperInfoCriteria;
import java.util.List;

public interface UserOperInfoSlaveMapper extends SelfMySQLSlaveMapper<UserOperInfo> {
    long countByCriteria(UserOperInfoCriteria criteria);

    List<UserOperInfo> selectByCriteria(UserOperInfoCriteria criteria);
}