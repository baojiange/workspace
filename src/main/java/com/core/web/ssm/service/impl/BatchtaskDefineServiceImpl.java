package com.core.web.ssm.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.core.web.ssm.bean.BatchtaskDefine;
import com.core.web.ssm.dao.BatchtaskDefineMapper;
import com.core.web.ssm.service.BatchtaskDefineService;

@Service("batchtaskDefineService")
public class BatchtaskDefineServiceImpl implements BatchtaskDefineService{

	
	@Resource
	private BatchtaskDefineMapper batchtaskDefineMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return batchtaskDefineMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(BatchtaskDefine record) {
		record.setCreateDate(new Date());
		record.setUpdateDate(new Date());
		return batchtaskDefineMapper.insert(record);
	}

	@Override
	public int insertSelective(BatchtaskDefine record) {
		return 0;
	}

	@Override
	public BatchtaskDefine selectByPrimaryKey(Long id) {
		return batchtaskDefineMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(BatchtaskDefine record) {
		record.setUpdateDate(new Date());
		return batchtaskDefineMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BatchtaskDefine record) {
		return 0;
	}

	@Override
	public List<BatchtaskDefine> findTaskList() {
		return batchtaskDefineMapper.getTaskList();
	}

}
