package main.java;


import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main{
    public static void main(String[] args)  {
          initComponents();
    }
    public  static  void initComponents()  {
        File file = new File("Users.json");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Country");
        ConcurrentHashMap<String , String > capitals = new ConcurrentHashMap<>(); // good for handling multi thread

        capitals.put("South Africa", "JHB");
        capitals.put("USA","New York");
        capitals.put("India","Mumbai");
        capitals.put("Turkey","Instanbul");
        capitals.put("Germany", "Berlin");

        //  Loop through and print all country-capital pairs


        Runnable task = ()-> {
            for (String country : capitals.keySet()) {
                System.out.println(country + " -> " + capitals.get(country));
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();

        }catch (InterruptedException e){
            e.printStackTrace();

        }


        if (file.exists() || file.length() == 0) {
            new RegistrationForm();


        }else{
            new LoginForm();
        }

    }
}