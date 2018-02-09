package sockets.conection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conection {
	private final int PUERTO = 1234;
	private final String HOST = "localhost"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conection (String type) throws IOException {
    	
    	if(type.equalsIgnoreCase("server")) {
    		 ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
             cs = new Socket(); 
    	}else {
    		cs = new Socket(HOST, PUERTO);
    	}
    	
    }
    
}
