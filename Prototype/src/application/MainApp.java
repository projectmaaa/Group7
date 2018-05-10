package application;

import database.Users;

public class MainApp {

	// public static String[] args;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Users users = new Users();
		LoginWindow.go();
	}

	// public static String[] getArgs() {
	// return args;
	// }
	//
	// public static void setArgs(String[] args) {
	// MainApp.args = args;
	// }

}
