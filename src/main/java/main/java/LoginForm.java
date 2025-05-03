package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginForm extends JFrame implements ActionListener {
        JPanel panel;
        JLabel user_label , password_label , message;
        JTextField username_text ;
        JPasswordField passwordField;
        JButton Login , cancel;

          public   LoginForm(){
                 user_label = new JLabel();
                 user_label.setText("User Name: ");
                 username_text = new JTextField();

              password_label = new JLabel();
              password_label.setText("Password: ");
              passwordField = new JPasswordField();

              Login = new JButton("Login");

              message = new JLabel();
            panel = new JPanel(new GridLayout(3, 1));
            panel.add(user_label);
            panel.add(username_text);
            panel.add(password_label);
            panel.add(passwordField);
            panel.add(message);
            panel.add(Login);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Login.addActionListener(this);

            add(panel, BorderLayout.CENTER);
            setTitle("Please Login Here !");
            setSize(450,350);
            setVisible(true);
        }




    @Override
    public  void actionPerformed(ActionEvent e) {

        String userName = username_text.getText();
        String password = new String(passwordField.getPassword());
        System.out.println("Hello " + userName);

    }
}
