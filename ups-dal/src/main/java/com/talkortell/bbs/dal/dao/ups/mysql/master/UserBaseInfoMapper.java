package com.talkortell.bbs.dal.dao.ups.mysql.master;

import com.talkortell.bbs.dal.dao.ups.base.SelfMySQLMasterMapper;
import com.talkortell.bbs.domain.mysql.ups.UserBaseInfo;
import com.talkortell.bbs.domain.mysql.ups.UserBaseInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBaseInfoMapper extends SelfMySQLMasterMapper<UserBaseInfo> {
    long countByCriteria(UserBaseInfoCriteria criteria);

    int deleteByCriteria(UserBaseInfoCriteria criteria);

    List<UserBaseInfo> selectByCriteria(UserBaseInfoCriteria criteria);

    int updateByCriteriaSelective(@Param("record") UserBaseInfo record, @Param("criteria") UserBaseInfoCriteria criteria);

    int updateByCriteria(@Param("record") UserBaseInfo record, @Param("criteria") UserBaseInfoCriteria criteria);
}