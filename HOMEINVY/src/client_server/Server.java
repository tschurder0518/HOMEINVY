package client_server;
import java.io.*;
import java.net.*;
import java.util.*;

import items.Item;

public class Server 
{
  public static void main(String[] args) {
     try {
        ServerSocket serversocket = new ServerSocket(9000);
        System.out.println("Server says: Server started ... waiting ...");
          
        while (true) {
           Socket socket = serversocket.accept();
           new Thread(new ProcessOneClient(socket)).start();
        }         
     }    
     catch (IOException e)
     {
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

           System.out.println("Thread Id for HOMEINVY = " + Thread.currentThread().getId() + " start");
   }
}