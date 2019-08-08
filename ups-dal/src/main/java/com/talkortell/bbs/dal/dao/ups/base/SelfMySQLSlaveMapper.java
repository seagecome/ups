package com.talkortell.bbs.dal.dao.ups.base;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.condition.SelectByConditionMapper;
import tk.mybatis.mapper.common.condition.SelectCountByConditionMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;
import tk.mybatis.mapper.common.example.SelectOneByExampleMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

public interface SelfMySQLSlaveMapper<T> extends BaseSelectMapper<T>, SelectOneByExampleMapper<T>, 
	SelectCountByExampleMapper<T>, SelectCountByConditionMapper<T>, RowBoundsMapper<T>, 
	SelectByIdsMapper<T>, SelectByConditionMapper<T>, Marker {

}
