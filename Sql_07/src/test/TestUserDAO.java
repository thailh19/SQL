package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import dataaccessobject.UserDAO;
import model.User;

public class TestUserDAO {
	public static int test_case = 3000;
	public static ArrayList<User> arr, arr2;
	public static int insertFail = 0;
	public static int insert2Fail = 0;
	public static int updateFail = 0;
	public static int update2Fail = 0;
	public static int deleteFail = 0;
	public static int delete2Fail = 0;
	
	public static long insTest = 0;
	public static long ins2Test = 0;
	
	public static long updTest = 0;
	public static long upd2Test = 0;
	
	public static long delTest = 0;
	public static long del2Test = 0;
	

	public static void main(String[] args) {
//		User user = new User("thu.ky", "10a", "Thư Kỳ");
//		UserDAO.getInstance().insert(user);
//		User user = new User();
//		user.setUsername("thu.ky");
//		UserDAO.getInstance().delete2(user);
		
//		ArrayList<User>  arrUser = UserDAO.getInstance().selectAll2();
//		for (User user2 : arrUser) {
//			System.out.println(user2);
//		}
		
//		User user = new User("XXX' OR 1=1; -- ", "", "");
//		System.out.println(UserDAO.getInstance().selectById(user));
//		System.out.println(UserDAO.getInstance().selectById2(user));
		
//		ArrayList<User>  arrUser = UserDAO.getInstance().selectByCondition2("username= 'truong.man'");
//		for (User user2 : arrUser) {
//			System.out.println(user2);
//		}
		
		System.out.println("---createDataUser test---");
		timenow();
		createDataUser();
		timenow();
		
		// insert test
		System.out.println("---insert test---");
		timenow();
		insTest = System.currentTimeMillis();
		for (int i = 0; i < test_case; i++) {
			UserDAO.getInstance().insert(arr.get(i));
		}
		timenow();
		insTest = System.currentTimeMillis() - insTest;
		ins2Test = System.currentTimeMillis();
		for (int i = 0; i < test_case; i++) {
			UserDAO.getInstance().insert2(arr2.get(i));
		}
		timenow();
		ins2Test = System.currentTimeMillis() - ins2Test;
		
		// update test
		createDataUser();
		System.out.println("---update test---");
		timenow();
		updTest = System.currentTimeMillis();
		for (int i = 0; i < test_case; i++) {
			UserDAO.getInstance().update(arr.get(i));
		}
		timenow();
		updTest = System.currentTimeMillis() - updTest;
		upd2Test = System.currentTimeMillis();
		for (int i = 0; i < test_case; i++) {
			UserDAO.getInstance().update2(arr2.get(i));
		}
		upd2Test = System.currentTimeMillis() - upd2Test;
		timenow();
		
		//delete test
		System.out.println("---delete test---");
		createNullDataUser();
		timenow();
		delTest = System.currentTimeMillis();
		for (int i = 0; i < test_case; i++) {
			UserDAO.getInstance().delete(arr.get(i));
		}
		timenow();
		delTest = System.currentTimeMillis() - delTest;
		del2Test = System.currentTimeMillis();
		for (int i = 0; i < test_case; i++) {
			UserDAO.getInstance().delete2(arr2.get(i));
		}
		del2Test = System.currentTimeMillis() - del2Test;
		timenow();
		
		System.out.println("---end test---");
		
		System.out.println("insertFail: "+insertFail + ", Time: " + insTest +"ms");
		System.out.println("insert2Fail: "+insert2Fail + ", Time: " + ins2Test +"ms");
		
		System.out.println("updateFail: "+updateFail + ", Time: " + updTest +"ms");
		System.out.println("update2Fail: "+update2Fail + ", Time: " + upd2Test +"ms");
		
		System.out.println("deleteFail: "+deleteFail + ", Time: " + delTest +"ms");
		System.out.println("delete2Fail: "+delete2Fail + ", Time: " + del2Test +"ms");
		
	}
	
	public static String createPassword (int l1, int l2) {
		String result = "";
		Random rd = new Random();
		int len = rd.nextInt(l1,l2);
		for (int i = 0; i < len; i++) {
			char c = (char) rd.nextInt(97,123);
			result += c;
		}
		return result;
	}
	
	public static String createName () {
		String result = "";
		Random rd = new Random();
		int len = rd.nextInt(2,5);
		for (int i = 0; i < len; i++) {
			result += createPassword(2, 7) + " ";
		}
		result.trim();
		return result;
	}

	public static void timenow () {
		Date now = new Date(); // java.util.Date, NOT java.sql.Date or java.sql.Timestamp!
		String format2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss.SSS", Locale.ENGLISH).format(now);
		System.out.println(format2);
	}
	
	public static void createDataUser () {
		arr = new ArrayList<User>();
		arr2 = new ArrayList<User>();
		
		for (int i = 0; i < test_case; i++) {
			User user = new User("test.id_" + i, createPassword(5, 11), createName());
			User user2 = new User ("test.id_" + (i + test_case), user.getPassword(), user.getName());
			arr.add(user);
			arr2.add(user2);
		}
	}
	
	public static void createNullDataUser() {
		arr = new ArrayList<User>();
		arr2 = new ArrayList<User>();
		
		for (int i = 0; i < test_case; i++) {
			User user = new User("test.id_" + i, "", "");
			User user2 = new User ("test.id_" + (i + test_case), "", "");
			arr.add(user);
			arr2.add(user2);
		}
	}

	
	
	
	
	
}