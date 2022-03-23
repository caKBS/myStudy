package com.ssafy.hw07.step2;


public class UserManagerImpl implements IUserManager {

	private static int MAX_SIZE = 100;
	private User[] userlist = new User[MAX_SIZE];
	private int size = 0;
	private static IUserManager instance = new UserManagerImpl();
	// 사용한 두 type이 올바른지 확인 필요?ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	
	private UserManagerImpl() {}
	
	public static IUserManager getUM() {
		return instance;
	}

	@Override
	public void add(User movie) {
		if (size < MAX_SIZE) {
			userlist[size++] = movie;
		}

	}

	@Override
	public User[] getList() {
		return userlist;
	}

	@Override
	public User[] searchByName(String name) {
		User[] searchList = new User[MAX_SIZE];
		int count = 0;

		for (int i = 0; i < size; i++) {

			if (userlist[i].getName().contains(name)) {
				searchList[count++] = userlist[i];
			}
		}
		return searchList;
	}

	@Override
	public User[] getUser() {
		User[] pureMovie = new User[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (!(userlist[i] instanceof VipUser)) {
				pureMovie[count++] = userlist[i];
			}
		}

		return pureMovie;
	}

	@Override
	public VipUser[] getVipUser() {
		VipUser[] SerMovie = new VipUser[MAX_SIZE];
		int count = 0;
		for (int i = 0; i < size; i++) {

			if (userlist[i] instanceof VipUser) {
				SerMovie[count++] = (VipUser) userlist[i];
			}
		}

		return SerMovie;
	}

	@Override
	public double getAgeAvg() {
		double rtSum = 0;

		for (int i = 0; i < size; i++) {
			rtSum = rtSum + userlist[i].getAge();
		}

		return (rtSum / size);
	}


}
