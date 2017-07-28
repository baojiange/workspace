package com.core.web.ssm.service;

import java.util.List;

import com.core.web.ssm.bean.BatchtaskDefine;

public interface BatchtaskDefineService {

    int deleteByPrimaryKey(Long id);

    int insert(BatchtaskDefine record);

    int insertSelective(BatchtaskDefine record);

    BatchtaskDefine selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BatchtaskDefine record);

    int updateByPrimaryKey(BatchtaskDefine record);
    
    /**
     * 获取任务列表
     * 
     */
    public List<BatchtaskDefine> findTaskList();
}
