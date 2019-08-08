package com.talkortell.bbs.dal.dao.ups.base;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.example.SelectOneByExampleMapper;

public interface SelfMySQLMasterMapper<T> extends BaseMapper<T>, SelectOneByExampleMapper<T>,
	RowBoundsMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>{

}
