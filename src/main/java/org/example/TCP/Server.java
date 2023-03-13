package org.example.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String clientMessage = "";
        String writeMessage = "";
        while(!clientMessage.equals("disconnect")){
            clientMessage = dataInputStream.readUTF();
            System.out.println("Client: "+ clientMessage);
            writeMessage = bufferedReader.readLine();
            dataOutputStream.writeUTF(writeMessage);
            dataOutputStream.flush();
        }
        dataInputStream.close();
        dataOutputStream.close();
        bufferedReader.close();
        serverSocket.close();




    }
}