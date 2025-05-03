package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message, title;
    JTextField username_text;
    JPasswordField passwordField;
    JButton loginButton, cancelButton;

    public LoginForm() {
        // Setting  up the frame
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setResizable(false);

        // Main panel with padding and background
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255)); // light blue

        // Title
        title = new JLabel("Please Login");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(0, 102, 204));
        title.setBounds(130, 10, 200, 30);
        panel.add(title);

        // Username
        user_label = new JLabel("Username:");
        user_label.setBounds(50, 60, 80, 25);
        username_text = new JTextField();
        username_text.setBounds(140, 60, 200, 25);
        panel.add(user_label);
        panel.add(username_text);

        // Password
        password_label = new JLabel("Password:");
        password_label.setBounds(50, 100, 80, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(140, 100, 200, 25);
        panel.add(password_label);
        panel.add(passwordField);

        // Message Label
        message = new JLabel();
        message.setBounds(50, 135, 300, 25);
        message.setForeground(Color.RED);
        panel.add(message);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(140, 170, 90, 30);
        loginButton.setBackground(new Color(0, 153, 76));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        // Cancel Button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 170, 90, 30);
        cancelButton.setBackground(new Color(204, 0, 0));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(e -> System.exit(0));
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = username_text.getText();
        String password = new String(passwordField.getPassword());

        // Simple validation and data encryption

    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
