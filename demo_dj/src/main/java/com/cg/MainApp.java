package com.cg;



import java.util.Scanner;

public class MainApp {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        Client client = new Client();
        client.execute();

        System.out.println("THỰC THI LẠI");
        String a = scanner.nextLine();
        System.out.println(a);

        client.setDao(client.getDao());
        client.execute();
    }
}