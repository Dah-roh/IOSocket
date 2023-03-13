package org.example.TCP;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String serverMessage = "";
        String writeMessage = "";
        while(!serverMessage.equals("disconnect")){
            writeMessage = bufferedReader.readLine();
            dataOutputStream.writeUTF(writeMessage);
            serverMessage = dataInputStream.readUTF();
            System.out.println("Server: "+ serverMessage);
        }

        dataInputStream.close();
        dataOutputStream.close();
        bufferedReader.close();
        socket.close();
    }
}
