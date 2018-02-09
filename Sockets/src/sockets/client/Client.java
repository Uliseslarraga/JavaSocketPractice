package sockets.client;

import java.io.DataOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sockets.conection.Conection;

public class Client extends Conection {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

	public Client() throws IOException {
		super("cliente");
	}

	public void startClient() {
		try {
			//Flujo de datos hacia el servidor
			salidaServidor = new DataOutputStream(cs.getOutputStream());
			
			 //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++){
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Este es el mensaje número " + (i+1) + "\n");
            }

            cs.close();//Fin de la conexión


		}catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
		}
	}
}
