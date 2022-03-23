package com.ssafy.hw07.step2;

public interface IUserManager {
	
	void add(User user);
	
	User [] getList();
	
	User [] searchByName(String name);
	
	User [] getUser();
	
	VipUser [] getVipUser();
	
	double getAgeAvg();

}
