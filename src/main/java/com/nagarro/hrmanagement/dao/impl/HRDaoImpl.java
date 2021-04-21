package com.nagarro.hrmanagement.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.hrmanagement.dao.HRDao;
import com.nagarro.hrmanagement.models.HRModel;

@Repository
public class HRDaoImpl implements HRDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public HRModel getHRDetails(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		HRModel user = session.get(HRModel.class, username);
		return user;

	}
}
