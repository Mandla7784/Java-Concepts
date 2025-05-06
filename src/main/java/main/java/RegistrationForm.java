package main.java;


import Database.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.json.JSONObject;

import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bson.Document;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.util.Base64;


public class RegistrationForm extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label, message, title;
    JTextField userName;
    JPasswordField passwordField;
    JButton google, register ,Login;

    public RegistrationForm() {
        setTitle("Register New User");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the form
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240, 248, 255)); // light blue

        // Title
        title = new JLabel("Create New Account");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(120, 20, 250, 30);
        title.setForeground(new Color(0, 102, 204));
        panel.add(title);

        // Username
        user_label = new JLabel("Username:");
        user_label.setBounds(50, 70, 80, 25);
        panel.add(user_label);

        userName = new JTextField();
        userName.setBounds(140, 70, 220, 25);
        panel.add(userName);

        // Password
        password_label = new JLabel("Password:");
        password_label.setBounds(50, 110, 80, 25);
        panel.add(password_label);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 110, 220, 25);
        panel.add(passwordField);

        // Message Label
        message = new JLabel();
        message.setBounds(50, 145, 300, 25);
        message.setForeground(Color.RED);
        panel.add(message);

        // Register Button
        register = new JButton("Register");
        register.setBounds(140, 180, 100, 30);
        register.setBackground(new Color(0, 153, 76));
        register.setForeground(Color.WHITE);
        register.setFocusPainted(false);
        register.addActionListener(this);
        panel.add(register);

        // Google Button
        google = new JButton("Sign up with Google");
        google.setBounds(140, 220, 180, 30);
        google.setBackground(new Color(219, 68, 55)); // Google red
        google.setForeground(Color.WHITE);
        google.setFocusPainted(false);
        google.addActionListener(this);
        panel.add(google);
        // Login if you already registered.
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if (e.getSource() == register) {
            String username = userName.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                message.setForeground(Color.RED);
                message.setText("Please fill in all fields.");
            } else {
                message.setForeground(new Color(0, 128, 0));
                //call encryption data
                try {
                    encryptPassword(password , username);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {

                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                message.setText("User registered successfully!");
                userName.setText(" ");
                passwordField.setText("");

                JOptionPane.showMessageDialog(this , "Registration successfully ");

                this.dispose();
                // direct to Log in form

                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);

            }
        } else if (e.getSource() == google) {
            message.setForeground(new Color(0, 102, 204));
        }
    }


    /***
     * Encryptes password using Cipher class , more advanced way to encrypt data in java
     * @param password
     * @param name
     * @throws Exception
     */
    public void encryptPassword(String password, String name) throws Exception {
        // Generate RSA key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();

        // Encrypt password
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedPassword = cipher.doFinal(password.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(encryptedPassword);

        // Create JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("password", encodedPassword);

        // Write to file using try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Users.json", true))) {
            writer.write(jsonObject.toString(4));
            writer.newLine();
        }

        // adding the json data /User to the database
        MongoDatabase database = MongoDBConnection.getDatabase("Register");
        MongoCollection<Document> collection = database.getCollection("myCollection");
        Document doc = Document.parse(jsonObject.toString());
        collection.insertOne(doc);
        System.out.println("User successfully added");
    }
}