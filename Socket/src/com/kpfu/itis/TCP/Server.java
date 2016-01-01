package com.kpfu.itis.TCP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        String msg;
        Socket socket = new Socket();
        int port = 2016;
        while (true){
            ServerSocket s = new ServerSocket(port);
            socket = s.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            msg = br.readLine();
            System.out.println("InputMessage: " + msg);
            msg += "(Edited)";
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(msg);
            //socket.close();
        }


    }
}
