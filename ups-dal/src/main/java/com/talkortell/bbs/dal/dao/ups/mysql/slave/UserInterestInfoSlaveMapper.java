package com.talkortell.bbs.dal.dao.ups.mysql.slave;

import com.talkortell.bbs.dal.dao.ups.base.SelfMySQLSlaveMapper;
import com.talkortell.bbs.domain.mysql.ups.UserInterestInfo;
import com.talkortell.bbs.domain.mysql.ups.UserInterestInfoCriteria;
import java.util.List;

public interface UserInterestInfoSlaveMapper extends SelfMySQLSlaveMapper<UserInterestInfo> {
    long countByCriteria(UserInterestInfoCriteria criteria);

    List<UserInterestInfo> selectByCriteria(UserInterestInfoCriteria criteria);
}