package guiClient;

import java.io.IOException;

import ocsf.client.AbstractClient;

public class GuiClient extends AbstractClient {

	public GuiClient(String host, int port) throws IOException {
		super(host, port);
		openConnection();
	}

	public void handleMessageFromClientUI(String message) {
		try {
			sendToServer(message);
		} catch (IOException e) {
			System.out.println("Could not send message to server. Terminating client.");
			quit();
		}
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub

	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

}