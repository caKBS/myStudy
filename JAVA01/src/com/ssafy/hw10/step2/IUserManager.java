package com.ssafy.hw10.step2;

public interface IUserManager {
	
	void add(User user);
	
	User [] getList();
	
	User [] searchByName(String name) throws NameNotFoundException;
	
	User [] getUser();
	
	VipUser [] getVipUser();
	
	double getAgeAvg();

	void saveData();
}
