package aesServer;

import java.sql.Connection;

import dataBaseAccessories.SqlConnection;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class AESserver extends AbstractServer {

	final public static int defaultPort = 3306;
	private Connection connection;

	public AESserver(int port) {
		super(port);
		connection = SqlConnection.connection();
	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		System.out.println("Message received: " + msg + " from " + client);
		switch ((String) msg) {
		case "Edit or Remove":
			break;
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	public static void main(String[] args) {
		int port = 0; // Port to listen on
		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = defaultPort; // Set port to 5555
		}
		AESserver server = new AESserver(port);
		try {
			server.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
}
