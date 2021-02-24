package client_server;
import java.io.*;
import java.net.*;
import java.util.*;

import items.Item;

public class Server {
	/* INTENT: Allow users to connect to application using sockets. Create threads
	 * for each user (socket). 
	 *  
	 * POSTCONDITION 1: Server is accepting socket connections from Clients.
	 * POST 2: Server makes new Thread object for each socket connection.
	 * POST 3: Thread number written to Server console when new Thread is created.
	 */
	public static void main(String[] args) {
		try {
			// Create new ServerSocket on port 9000
			ServerSocket serversocket = new ServerSocket(9000);
			System.out.println("Server says: Server started ... waiting ...");
        
		// Accept incoming socket connections, create new Thread for each connection
        while (true) {
           Socket socket = serversocket.accept();
           // Create new thread by calling class ProcessOneClient
           new Thread(new ProcessOneClient(socket)).start();
        	}         
		}    
		catch (IOException e) {
			e.printStackTrace();
		}     
	} 
}

class ProcessOneClient implements Runnable {
    private Socket socket;

    public ProcessOneClient(Socket s) {
       socket = s;              
    }

    public void run() {
    	// Print thread number each time new thread is created
    	System.out.println("Thread Id for HOMEINVY = " + Thread.currentThread().getId() + " start");
   }
}