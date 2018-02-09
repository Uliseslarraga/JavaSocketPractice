package sockets.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sockets.client.Client;

public class MainClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainClient.class);
	
	public static void main(String[] args) throws IOException {
		
		Client client = new Client();
		LOGGER.info("Iniciando cliente");
		client.startClient();
		
	}
	
}
