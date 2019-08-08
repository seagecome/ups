package com.talkortell.bbs.dal.dao.ups.mysql.master;

import com.talkortell.bbs.dal.dao.ups.base.SelfMySQLMasterMapper;
import com.talkortell.bbs.domain.mysql.ups.UserInterestInfo;
import com.talkortell.bbs.domain.mysql.ups.UserInterestInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInterestInfoMapper extends SelfMySQLMasterMapper<UserInterestInfo> {
    long countByCriteria(UserInterestInfoCriteria criteria);

    int deleteByCriteria(UserInterestInfoCriteria criteria);

    List<UserInterestInfo> selectByCriteria(UserInterestInfoCriteria criteria);

    int updateByCriteriaSelective(@Param("record") UserInterestInfo record, @Param("criteria") UserInterestInfoCriteria criteria);

    int updateByCriteria(@Param("record") UserInterestInfo record, @Param("criteria") UserInterestInfoCriteria criteria);
}