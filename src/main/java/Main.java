



import javax.swing.*;
import java.awt.*;

import java.util.*;

public class Main {
    static CardLayout layout;
    static JPanel mainPanel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {
        }

        JFrame frame = new JFrame("ABSA Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        mainPanel.add(loginScreen(frame), "login");
        mainPanel.add(dashboardScreen(), "dashboard");
        mainPanel.add(profileScreen(), "profile"); // Add Profile screen

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        youtube();
    }

    // Login screen
    private static JPanel loginScreen(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.decode("#7D0038"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        JLabel title = new JLabel("Welcome to ABSA");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(Color.WHITE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        JPasswordField passField = new JPasswordField(15);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(Color.decode("#FFC72C"));
        loginBtn.setForeground(Color.BLACK);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(userLabel, gbc);
        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passLabel, gbc);
        gbc.gridx = 1;
        panel.add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(loginBtn, gbc);

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = String.valueOf(passField.getPassword());

            if (username.equalsIgnoreCase("mandla") && password.equals("1234")) {
                layout.show(mainPanel, "dashboard");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    // Dashboard
    private static JPanel dashboardScreen() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#F5F5F5"));

        JLabel welcome = new JLabel("Hello Mandla!", SwingConstants.CENTER);
        welcome.setFont(new Font("SansSerif", Font.BOLD, 20));
        welcome.setOpaque(true);
        welcome.setBackground(Color.decode("#7D0038"));
        welcome.setForeground(Color.WHITE);
        welcome.setPreferredSize(new Dimension(100, 50));
        panel.add(welcome, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        center.setBackground(Color.decode("#F5F5F5"));

        JLabel balanceLabel = new JLabel("Account Balance: R5,000.00");
        balanceLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton depositBtn = new JButton("💵Deposit");
        JButton withdrawBtn = new JButton(" 🏧Withdraw");
        JButton profileBtn = new JButton(" 👁️View Profile");

        depositBtn.setBackground(Color.decode("#FFC72C"));
        withdrawBtn.setBackground(Color.decode("#FFC72C"));
        profileBtn.setBackground(Color.decode("#FFC72C"));

        depositBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        withdrawBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        profileBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        center.add(balanceLabel);
        center.add(Box.createRigidArea(new Dimension(0, 20)));
        center.add(depositBtn);
        center.add(Box.createRigidArea(new Dimension(0, 10)));
        center.add(withdrawBtn);
        center.add(Box.createRigidArea(new Dimension(0, 10)));
        center.add(profileBtn);

        panel.add(center, BorderLayout.CENTER);

        // View profile
        profileBtn.addActionListener(e -> layout.show(mainPanel, "profile"));

        return panel;
    }

    // Profile screen
    private static JPanel profileScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.decode("#FFFFFF"));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Profile Information", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel name = new JLabel("Name: Mandla Dyonase");
        JLabel email = new JLabel("Email: mandla@example.com");
        JLabel accNumber = new JLabel("Account #: 1234-5678-9012");

        name.setFont(new Font("SansSerif", Font.PLAIN, 16));
        email.setFont(new Font("SansSerif", Font.PLAIN, 16));
        accNumber.setFont(new Font("SansSerif", Font.PLAIN, 16));

        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        email.setAlignmentX(Component.CENTER_ALIGNMENT);
        accNumber.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backBtn = new JButton("← Back");
        backBtn.setBackground(Color.decode("#FFC72C"));
        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        backBtn.addActionListener(e -> layout.show(mainPanel, "dashboard"));

        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(email);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(accNumber);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(backBtn);

        return panel;
    }

    private static void youtube() {
        int numbers[] = {1, 2, 3, 4, 5, 6};
        Random random = new Random();
        System.out.println(random.nextInt());

        int sum = 0;
        for (int num : numbers) {
            sum += num;

        }
        System.out.println(sum);
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.get(0);
        nums.forEach(Integer -> System.out.println(Integer));
         nums.remove(Integer.valueOf(0));
         nums.stream().count();
         nums.sort(Comparator.naturalOrder());
         nums.sort(Comparator.reverseOrder());
         nums.trimToSize();
         nums.size();
        System.out.println(Arrays.toString(numbers));
        nums.forEach(num -> {
            if(num % 2 == 0 || num %2 != 0){
                System.out.println(num);
            }
        });
        for(Integer i : nums){
            System.out.println(i);
        }
        HashMap<String  , Integer > scoreSubject = new HashMap<>();



        scoreSubject.put("Englis" ,80);
        scoreSubject.put("Math", 75);
        scoreSubject.put("Programming" , 100);
        if(scoreSubject.containsKey("math")) JOptionPane.showMessageDialog(null  ,"Its exoits");

        scoreSubject.forEach((subject , grade)-> {
            if(grade < 80) grade = grade + 5;

        });
    }


}