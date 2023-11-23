package SocketProgram;


import java.io.*;
import java.net.*;

public class SocketServer {

	public static void main(String[] args) throws IOException {
        String clientGelen;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        int sayi;
        int ascii;
        char ch;
        try {
             serverSocket = new ServerSocket(6013);
        } catch (Exception e) {
             System.out.println("Port Hatas�!");
        }
        System.out.println("SERVER BA�LANTI ���N HAZIR...");
        clientSocket = serverSocket.accept();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while((clientGelen = in.readLine()) != null) {
             System.out.println("Client'dan gelen veri = " + clientGelen);
             sayi = Integer.valueOf(clientGelen);
             ascii = sayi;
             ch = (char) ascii;
             out.println(ch);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
   }
}

