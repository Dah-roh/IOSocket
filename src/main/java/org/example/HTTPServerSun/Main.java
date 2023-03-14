package org.example.HTTPServerSun;


import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        //creates connection ip and port
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        //creates a path context to server once a path location is reached
        httpServer.createContext("/", new HomePage());
        httpServer.createContext("/aboutus", new AboutUs());
        //starts our http server
        httpServer.start();
    }
}
