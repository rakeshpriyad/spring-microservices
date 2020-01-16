package com.test.bank.branch;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int port = 6666;
        startServer1(port);
    }

    public static void startServer1(int port) throws IOException, ClassNotFoundException{
        //create the socket server object
        ServerSocket server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for req");
            run( server.accept());
        }
        //System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
       // server.close();
    }

public  static  void run( Socket socket)  {
        Runnable r = () -> {
            try {
              //  System.out.println("Waiting for the client request");
                //creating socket and waiting for client connection

                //read from socket to ObjectInputStream object
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //convert ObjectInputStream object to String
                String message = (String) ois.readObject();
                System.out.println("Message Received: " + message);
                //create ObjectOutputStream object
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //write object to Socket
                oos.writeObject("Hi Client " + message);
                //close resources
                //  ois.close();
                //   oos.close();
                //  socket.close();
                //terminate the server if client sends exit request
                if (message.equalsIgnoreCase("exit")) System.exit(0);
            }catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread t = new Thread(r);
        t.start();
}
}
