package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        final int PORT = 8888;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.printf("New connection accepted. Port %d%n", clientSocket.getPort());
                    String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    out.println("Write your name");
                    //
                    String username = in.readLine();
                    System.out.println(username);
                    out.println("Are you child? (yes/no)");
                    //
                    String input = in.readLine();
                    if (input.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, " + username + "! Let's play!"));
                    } else {
                        out.println(String.format("Welcome to the adult zone, " + username + "! Have a good rest, or a good working day!"));
                    }
                }
            }
        }
    }
}
