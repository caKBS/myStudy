package com.ssafy.fit.model.dao;

import com.ssafy.fit.model.User;



public interface IUserDao {

	void loadData();
	
	void saveData();
	
	void add(User user);
	

	
}

