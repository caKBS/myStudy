package com.ssafy.fit.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.User;

public class UserDao implements IUserDao {

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	private UserDao() {
		
	}

	private List<User> userlist = new ArrayList<>();

	public void loadData() {
////		File target = new File(
////				"C:\\Users\\kbsrl\\eclipse-workspace" + 
////		        "\\JAVA01\\src\\com\\ssafy\\hw10\\step2\\user.dat");
////		if (target.exists()) {
//			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
//				
//
//				userlist = (List<User>) ois.readObject();
//			
//
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
////		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
            List<User> list = (List<User>) ois.readObject();
            for (User m : list) {
                System.out.println(m);
            }

            if (list != null) {
                userlist = list;
            }
        } catch (FileNotFoundException e) {
            System.out.println("해당 파일이 없습니다.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
	

	}

	public void saveData() {

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.dat"))) {

			os.writeObject(userlist);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void add(User user) {
		userlist.add(user);

	}


}
