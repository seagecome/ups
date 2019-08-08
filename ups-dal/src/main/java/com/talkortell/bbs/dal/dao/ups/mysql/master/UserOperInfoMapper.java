package com.talkortell.bbs.dal.dao.ups.mysql.master;

import com.talkortell.bbs.dal.dao.ups.base.SelfMySQLMasterMapper;
import com.talkortell.bbs.domain.mysql.ups.UserOperInfo;
import com.talkortell.bbs.domain.mysql.ups.UserOperInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOperInfoMapper extends SelfMySQLMasterMapper<UserOperInfo> {
    long countByCriteria(UserOperInfoCriteria criteria);

    int deleteByCriteria(UserOperInfoCriteria criteria);

    List<UserOperInfo> selectByCriteria(UserOperInfoCriteria criteria);

    int updateByCriteriaSelective(@Param("record") UserOperInfo record, @Param("criteria") UserOperInfoCriteria criteria);

    int updateByCriteria(@Param("record") UserOperInfo record, @Param("criteria") UserOperInfoCriteria criteria);
}