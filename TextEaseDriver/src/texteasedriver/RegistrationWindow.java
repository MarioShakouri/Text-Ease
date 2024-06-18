package texteasedriver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author hayapirzada
 */
/**
 * @author shabo
 */

public class RegistrationWindow {
    private JFrame registrationFrame;
    private JPanel registrationPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel username, password;
    private JButton loginButton, createAccount, ttsButton;
    private JLabel logoLabel;

    public RegistrationWindow() {
        // Initialize frame
        registrationFrame = new JFrame("Registration Screen");

        // Panel with BoxLayout and background color set
        registrationPanel = new JPanel();
        registrationPanel.setLayout(new BoxLayout(registrationPanel, BoxLayout.Y_AXIS));
        registrationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Added padding around the panel
        registrationPanel.setBackground(new Color(155, 77, 56));

        // Load the logo image
        ImageIcon image = new ImageIcon("TextEaseDriver/src/logo.png");
        Image scaledImage = image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        logoLabel = new JLabel(scaledIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Username styling
        username = new JLabel("Username: ");
        username.setFont(new Font("Arial", Font.BOLD, 18));
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField(15);
        usernameField.setMaximumSize(usernameField.getPreferredSize());
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Password styling
        password = new JLabel("Password: ");
        password.setFont(new Font("Arial", Font.BOLD, 18));
        password.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(passwordField.getPreferredSize());
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Login button styling
        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(91, 100, 118));
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the username and password entered by the user
                String usernameInput = usernameField.getText();
                String passwordInput = new String(passwordField.getPassword());

                // Check if the login is successful using the User.logIn method
                if (User.logIn(usernameInput, passwordInput)) {
                    // If login is successful, close the current registration frame
                    registrationFrame.dispose();
                    // Open the main application window (TextEaseGUI)
                    new TextEaseGUI();
                } else {
                    // If login fails, show an error message dialog
                    JOptionPane.showMessageDialog(registrationFrame, "Invalid username or password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Register button styling
        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(91, 100, 118));
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dispose registerWindow first
                registrationFrame.dispose();
                // Open registration portal window
                new RegistrationPortalWindow();
            }
        });

        // Text to speech button
        ttsButton = new JButton("Text To Speech");
        ttsButton.setBounds(200, 150, 150, 30);
        ttsButton.setBackground(new Color(91, 100, 118));
        ttsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action listener
        ttsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextToSpeech tts = new TextToSpeech();
                tts.speak("WELCOME TO THE TEXTEASE APPLICATION. Please enter username and password to login. Or Click register to create a new account");
            }
        });

        // A panel for the buttons with FlowLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(new Color(155, 77, 56));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        // Components to panel
        registrationPanel.add(logoLabel); // Add the logo at the top
        registrationPanel.add(username);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        registrationPanel.add(usernameField);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        registrationPanel.add(password);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        registrationPanel.add(passwordField);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        registrationPanel.add(buttonPanel);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        registrationPanel.add(ttsButton);

        // Frame setup
        registrationFrame.add(registrationPanel);
        registrationFrame.pack(); // Adjust frame to fit all components
        registrationFrame.setLocationRelativeTo(null);
        registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrationFrame.setVisible(true);
    }
}

