package org.example.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MessengerDatagramOne {
    public static void main(String[] args) throws IOException {
        //create a data byte array
        byte [] data =  new byte[677777];

        // and DatagramSocket for locating recipient
        DatagramSocket receiver;
        receiver = new DatagramSocket(8082);
        //and a DatagramPacket for receiving the data
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        while(true) {
            receiver.receive(datagramPacket);


            //finally we print our received data
            int i = 0;
            StringBuilder receivedMessage = new StringBuilder();
            while (data[i] != 0) {
                receivedMessage.append((char) data[i]);
                i++;
            }
            //closing your port's process
            if(receivedMessage.toString().equals("close")){
                receiver.close();
            }

            //remember to flush data byte array
            data = new byte[677777];

            System.out.println("Received:- " + receivedMessage);
        }

    }

}
