package com.ssafy.hw10.step2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws10.step2.Movie;
import com.ssafy.ws10.step2.SeriesMovie;
import com.ssafy.ws10.step2.TitleNotFoundException;

public class UserManagerImpl implements IUserManager {

	private List<User> userlist = new ArrayList<>();
	private static IUserManager instance = new UserManagerImpl();
	// 사용한 두 type이 올바른지 확인 필요?ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	
	private UserManagerImpl() {
		loadData();
	}
	
	public static IUserManager getUM() {
		return instance;
	}

	@Override
	public void add(User movie) {
		userlist.add(movie);

	}

	@Override
	public User[] getList() {
		User[] result = new User[userlist.size()];
		for (int i = 0; i < userlist.size(); i++) {
			result[i] = userlist.get(i);
		}
		return result;
	}

	@Override
	public User[] searchByName(String name) throws NameNotFoundException {
		User[] searchList = new User[userlist.size()];
		int count = 0;

		for (int i = 0; i < userlist.size(); i++) {

			if (userlist.get(i).getName().contains(name)) {
				searchList[count++] = userlist.get(i);
			}
		}
		if (count == 0) {
			throw new NameNotFoundException(name);

		}
		return searchList;
	}

	@Override
	public User[] getUser() {
		User[] pureUser = new User[userlist.size()];
		int count = 0;
		for (int i = 0; i < userlist.size(); i++) {

			if (!(userlist.get(i) instanceof VipUser)) {
				pureUser[count++] = userlist.get(i);
			}
		}

		return pureUser;
	}


	@Override
	public VipUser[] getVipUser() {
		VipUser[] SerMovie = new VipUser[userlist.size()];
		int count = 0;
		for (int i = 0; i < userlist.size(); i++) {

			if (userlist.get(i)instanceof VipUser) {
				SerMovie[count++] = (VipUser) userlist.get(i);
			}
		}

		return SerMovie;
	}

	@Override
	public double getAgeAvg() {
		double rtSum = 0;

		for (int i = 0; i < userlist.size(); i++) {
			rtSum = rtSum + userlist.get(i).getAge();
		}

		return (rtSum / userlist.size());
	}
	
	private void loadData() {
		File target = new File(
				"C:\\Users\\kbsrl\\eclipse-workspace" + 
		        "\\JAVA01\\src\\com\\ssafy\\hw10\\step2\\user.dat");
		if (target.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))) {

				userlist = (List<User>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public void saveData() {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(
				"C:\\Users\\kbsrl\\eclipse-workspace\\JAVA01\\src\\com" + 
		        "\\ssafy\\hw10\\step2\\user.dat"))) {

			os.writeObject(userlist);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
