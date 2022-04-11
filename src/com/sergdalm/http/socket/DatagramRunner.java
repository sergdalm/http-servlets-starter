package com.sergdalm.http.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        var interAddress = InetAddress.getByName("localhost");

        try (var datagramSocket = new DatagramSocket()) {
            var bytes = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, interAddress, 7777);
            datagramSocket.send(packet);
        }
    }
}
