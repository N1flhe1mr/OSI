package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        final String HOST = "netology.homework";
        final int PORT = 8888;
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("client");
            String resp = in.readLine();
            System.out.println(resp);
            //
            resp = in.readLine();
            System.out.println(resp);
            out.println("Dmitriy");
            //
            resp = in.readLine();
            System.out.println(resp);
            out.println("no");
            //
            resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
