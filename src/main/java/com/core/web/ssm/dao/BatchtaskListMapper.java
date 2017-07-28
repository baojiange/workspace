package com.core.web.ssm.dao;

import com.core.web.ssm.bean.BatchtaskList;


public interface BatchtaskListMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(BatchtaskList record);

    int insertSelective(BatchtaskList record);

    BatchtaskList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BatchtaskList record);

    int updateByPrimaryKey(BatchtaskList record);
}