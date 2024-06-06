/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public RegistrationWindow() {

        //initialize frame
        registrationFrame = new JFrame("Registration Screen");
        //panel with BoxLayout and background color set-ms
        registrationPanel = new JPanel();
        registrationPanel.setLayout(new BoxLayout(registrationPanel, BoxLayout.Y_AXIS));
        registrationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Added padding around the panel
        registrationPanel.setBackground(new Color(159, 147, 147));


  //username styling-ms
  username = new JLabel("Username: ");
  username.setFont(new Font("Arial", Font.BOLD,14));
  username.setAlignmentX(Component.CENTER_ALIGNMENT);

  usernameField = new JTextField(15);
  usernameField.setMaximumSize(usernameField.getPreferredSize());
  usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);


    //password styling-ms
    password = new JLabel("Password: ");
    password.setFont(new Font("Arial", Font.BOLD, 14));
    password.setAlignmentX(Component.CENTER_ALIGNMENT);

    passwordField = new JPasswordField(15);
    passwordField.setMaximumSize(passwordField.getPreferredSize());
    passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

    //login button styling
    loginButton = new JButton("login");
    loginButton.setBackground(new Color(255,243,243));
    loginButton.setFont(new Font("Arial", Font.BOLD, 14));
    loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    //action listeners
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(usernameField.getText().equals("user")){
                registrationFrame.dispose();
                new TextEaseGUI();
            } else{
                JOptionPane.showMessageDialog(registrationFrame, "Error try again or register now", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

        // Register button styling
        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(255, 243, 243));
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //open registration portal window
            new RegistrationPortalWindow();
            }
            });

        // text to speech button
        ttsButton = new JButton("Text To Speech");
    ttsButton.setBounds(200, 150, 150, 30);
    ttsButton.setBackground(new Color(239, 226, 226));
    ttsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    //action listener
        ttsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextToSpeech tts = new TextToSpeech();
                tts.speak("WELCOME TO THE TEXTEASE APPLICATION. Please enter username and password to login. Or Click register to create a new account");
            }
        });


        // a panel for the buttons with FlowLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(new Color(159, 147, 147));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
      
    //components to panel -ms
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
  
    
    
   //frame setup -ms
    registrationFrame.add(registrationPanel);
    registrationFrame.pack(); //adjust frame to fit all components
    registrationFrame.setLocationRelativeTo(null);
    registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    registrationFrame.setVisible(true);
}
}
