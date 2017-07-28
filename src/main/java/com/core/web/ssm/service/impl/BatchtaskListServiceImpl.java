package com.core.web.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.core.web.ssm.bean.BatchtaskList;
import com.core.web.ssm.dao.BatchtaskListMapper;
import com.core.web.ssm.service.BatchtaskListService;

@Service("batchtaskListService")
public class BatchtaskListServiceImpl implements BatchtaskListService{
	
	
	@Resource
	private BatchtaskListMapper batchtaskListMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(BatchtaskList record) {
		return batchtaskListMapper.insert(record);
	}

	@Override
	public int insertSelective(BatchtaskList record) {
		return 0;
	}

	@Override
	public BatchtaskList selectByPrimaryKey(Long id) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(BatchtaskList record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(BatchtaskList record) {
		return 0;
	}

}
