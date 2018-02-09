package sockets.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sockets.conection.Conection;

public class Server extends Conection{

	private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
	
	public Server() throws IOException {
		super("server");
	}

	public void startServer() {
		try {
			LOGGER.info("Esperando...");
			cs = ss.accept();
			LOGGER.info("Cliente en línea");
			
			//Se obtiene el flujo de salida del cliente para enviarle mensajes
			salidaCliente = new DataOutputStream(cs.getOutputStream());
			
			//Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");
			
          //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            
			while((mensajeServidor = entrada.readLine()) != null){  //Mientras haya mensajes desde el cliente
                //Se muestra por pantalla el mensaje recibido
                LOGGER.info(mensajeServidor);
            }
			
			LOGGER.info("Fin de la conexión");
			
			ss.close();
			
		}catch(Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
	}
	
}
