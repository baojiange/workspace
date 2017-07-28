package com.core.web.ssm.service;

import com.core.web.ssm.bean.BatchtaskList;

public interface BatchtaskListService {

    int deleteByPrimaryKey(Long id);

    int insert(BatchtaskList record);

    int insertSelective(BatchtaskList record);

    BatchtaskList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BatchtaskList record);

    int updateByPrimaryKey(BatchtaskList record);
}
