package main.java;

import java.io.File;
import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws  FileNotFoundException {
          initComponents();
    }
    public  static  void initComponents()  {
        // if the file is empty then show Registration form ;
        // else show Login if thre is users already
      File file = new File("Users.json");
      if(  file.exists() || file.length() == 0){
          new RegistrationForm();

      }else{
          new LoginForm();

      }
    }
}