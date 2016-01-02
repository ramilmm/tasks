package com.kpfu.itis.TCP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String myName = sc.nextLine();
        String name;
        String msg = sc.nextLine();
        InetAddress add = InetAddress.getByName("localhost");
        int port = 2016;
        Socket s = new Socket(add,port);
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        pw.println(myName);

        BufferedReader brw = new BufferedReader(new InputStreamReader(s.getInputStream()));
        name = brw.readLine();
        System.out.println("Your partner name : " + name);
    }
}
