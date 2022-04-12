package com.sergdalm.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        checkGoggle();
        printFile();
    }

    private static void printFile() throws IOException {
        var url = new URL("file:C:\\Users\\Hello\\Documents\\GitHub\\http-servlets-starter\\src\\com\\sergdalm\\http\\socket\\DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoggle() throws IOException {
        URL url = new URL("https://google.com");
        URLConnection urlConnection = url.openConnection();
        System.out.println();
        String contentType = urlConnection.getContentType();
//        urlConnection.setDoOutput(true);
//        try (OutputStream outputStream = urlConnection.getOutputStream()) {
//        }
    }
}
