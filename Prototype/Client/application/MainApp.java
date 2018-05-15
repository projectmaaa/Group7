package application;

import java.io.IOException;

import guiClient.GuiClient;

public class MainApp {

	private GuiClient client;
	final public static int defaultPort = 3306;

	public MainApp(String host, int port) {
		try {
			client = new GuiClient(host, port);
		} catch (IOException e) {
			System.out.println("Error: Can't setup connection! Terminating client.");
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		String host = "";
		try {
			host = args[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			host = "localhost";
		}
		MainApp userApp = new MainApp(host, defaultPort);
		LoginWindow.go();
	}
}