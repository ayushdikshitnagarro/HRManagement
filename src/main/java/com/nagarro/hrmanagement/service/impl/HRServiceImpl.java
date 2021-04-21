package com.nagarro.hrmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.hrmanagement.dao.HRDao;
import com.nagarro.hrmanagement.models.HRModel;
import com.nagarro.hrmanagement.service.HRService;

@Service
public class HRServiceImpl implements HRService {

	@Autowired
	HRDao hrdao;
	
	public HRModel getUserDetails(String userName) {
		return this.hrdao.getHRDetails(userName);
	}

}
