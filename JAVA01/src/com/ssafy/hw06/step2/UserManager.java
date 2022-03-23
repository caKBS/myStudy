package com.ssafy.hw06.step2;


public class UserManager {
	
	private int MAX_SIZE = 100;
	private int size = 0;
	private User[] userlist = new User[MAX_SIZE];

	public void add(User movie) {
		if (size < MAX_SIZE) {
			userlist[size++] = movie;
		}
	}

	public User[] getList() {
		return userlist;
	}

	public User[] getUsers() {
		User[] pureUsers= new User[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (!(userlist[i] instanceof VipUser)) {
				pureUsers[count++] = userlist[i];
			}
		}

		return pureUsers;
	}

	public VipUser[] getVipUsers() {
		VipUser[] VipUsers = new VipUser[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (userlist[i] instanceof VipUser) {
				VipUsers[count++] = (VipUser) userlist[i];
			}
		}

		return VipUsers;

	}

	public User[] searchByName(String name) {
		User[] searchList = new User[MAX_SIZE];
		int count = 0;

		for (int i = 0; i < size; i++) {

			if (userlist[i].getName().contains(name)) {
				searchList[count++] =userlist[i];
			}
		}
		return searchList;
	}

	public double getAgeAvg() {
		double rtSum = 0;

		for (int i = 0; i < size; i++) {
			rtSum = rtSum + userlist[i].getAge();
		}

		return (rtSum / size);

	}

}

//End