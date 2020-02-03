package singleton;

import controller.MemberController;
import controller.CoffeeController;

public class Singleton {
	private static Singleton s = null;
	public MemberController memCtrl = null;
	public CoffeeController coffeeCtrl = null;
	private String loginID = null;

	private Singleton() {
		memCtrl = new MemberController();
		coffeeCtrl = new CoffeeController();
	}

	public static Singleton getInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
}
