package com.nagarro.hrmanagement.dao;

import com.nagarro.hrmanagement.models.HRModel;

public interface HRDao {

	HRModel getHRDetails(String username);

}
