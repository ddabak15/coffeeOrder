package main;

import db.DBConnection;
import singleton.Singleton;
import view.cartView;
import view.orderView;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		Singleton s = Singleton.getInstance();
		s.memCtrl.login();
//		new orderView();
//		new cartView();

	}

}
