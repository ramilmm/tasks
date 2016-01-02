package com.kpfu.itis.UDP;


import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = new Logger();
        Scanner sc = new Scanner(System.in);
        System.out.print("Write your nickname: ");
        String myName = sc.nextLine();
        String name = "";

        try {
            DatagramSocket ds = new DatagramSocket(2016);
            //receiving partner name
            DatagramPacket dp2 = new DatagramPacket(new byte[30], 30);
            ds.receive(dp2);
            name = new String(dp2.getData());
            System.out.println("Name of your chat partner: " + name);
            //sending my name
            DatagramPacket dname = new DatagramPacket(myName.getBytes(),myName.getBytes().length, InetAddress.getByName("localhost"),2015);
            ds.send(dname);
            //chat
            while (true) {
                dp2 = new DatagramPacket(new byte[500],500);
                String inputMSG = "";
                ds.receive(dp2);
                inputMSG = new String(dp2.getData());
                if(inputMSG.equalsIgnoreCase("exit")){
                    System.out.println(name + " left the chat.");
                    ending();
                }
                System.out.println(name + ": " + inputMSG);
                System.out.print(myName+": ");
                String msg = sc.nextLine();
                logger.logEvent(myName + ": " + msg);
                DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("localhost"), 2015);
                ds.send(dp);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void ending() throws InterruptedException {
        System.out.println("We try to connect with your friend.Please wait.");
        for (int i = 0; i < 100; i++) {
            System.out.print(".");
            Thread.sleep(100);

        }
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
        Thread.sleep(1000);
        System.out.println("Sorry,but your friend does not want to chatting with you ;(");
        Thread.sleep(1000);
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tGOOD BYE!");
        Thread.sleep(1000);
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.exit(0);
    }
}
