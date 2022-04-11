package com.sergdalm.http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {
        try (var datagramSocket = new DatagramSocket(7777)) {
            byte[] buffer = new byte[100];
            var packet = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(packet);

            System.out.println(new String(buffer));
        }
    }
}
