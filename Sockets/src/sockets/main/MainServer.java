package sockets.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sockets.server.Server;

public class MainServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainServer.class);
	
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		LOGGER.info("Iniciando servidor");
		
		server.startServer();
	}

}
