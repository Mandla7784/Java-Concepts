package main.java;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;


public class Main{
    public static void main(String[] args)  {
          initComponents();
    }
    public  static  void initComponents()  {
        File file = new File("Users.json");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Country");
        HashMap<String , String > capitals = new HashMap<>();
        capitals.put("South Africa", "JHB");
        capitals.put("USA","New York");
        capitals.put("India","Mumbai");
        capitals.put("Turkey","Instanbul");
        capitals.put("Germany", "Berlin");
        //  Loop through and print all country-capital pairs
        for (String country : capitals.keySet()) {
            System.out.println(country + " -> " + capitals.get(country));
        }
        if (file.exists() || file.length() == 0) {
            new RegistrationForm();


        }else{
            new LoginForm();
        }

    }
}