package org.example.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class MessengerDatagramTwo {
    public static void main(String[] args) throws IOException {
        //create a data byte array
        byte[] data = new byte[677777];

        // and a Scanner to read from system.in
        // (or for memorisation purpose, system input)
        Scanner scanner = new Scanner(System.in);
        //and then a DatagramSocket to locate recipient of data
        DatagramSocket sender = new DatagramSocket();
        while (true) {


            //reading Scanner input to bytes
            String message = scanner.nextLine();
            data =  message.getBytes();
            //then a DatagramPacket for sending the data to
            //the recipient's address using IP address and
            //process port number
            DatagramPacket datagramPacket = new DatagramPacket(data,
                    data.length, InetAddress.getLocalHost(), 8082);

            //send data
            sender.send(datagramPacket);

            //remember to flush your byte array
            data = new byte[677777];
        }
    }


}
