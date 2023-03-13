package org.example.HTTPServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true){
            try(Socket socket = serverSocket.accept()) {
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String endpoint = bufferedReader.readLine().split(" ")[1];
                if (endpoint.equals("/home")) {
                    socket.getOutputStream()
                            .write(("HTTP/1.1 200 OK" + "\r\n\r\n" + "Welcome to HomePage")
                                    .getBytes("UTF-8"));
                } else {
                    socket.getOutputStream()
                            .write(("HTTP/1.1 200 OK" + "\r\n\r\n" + "404 This page was not found.")
                                    .getBytes("UTF-8"));
                }
            }catch (IOException exception){
        }
    }
}
