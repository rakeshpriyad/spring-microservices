package com.test.bank.branch;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocketClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        int port =6666;
       /* for (int i=0; i< 20000; i++) {
            startServer(port, "Hello"+i);
        }*/

        startClient1(port);
    }

    public  static  void startClient1(int port) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        int n =100000;
        for(int i=0; i<n;i++){
            //establish socket connection to server
            socket = new Socket(host.getHostName(), port);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(i== n-1)oos.writeObject("exit");
            else oos.writeObject(""+i);
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);
            //close resources
           // ois.close();
            //oos.close();
           // Thread.sleep(2);
        }
    }
    public static void startServer(int port, String message) {
        try{
            System.out.println(" sending message: " + message);
            Socket s=new Socket("localhost",port);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            dout.writeUTF(message);
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println(e);}
    }

}
