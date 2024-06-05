/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteasedriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author hayapirzada
 */
public class RegistrationWindow {
    private JFrame registrationFrame;
    private JPanel registrationPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel username, password;
    private JButton loginButton, createAccount, ttsButton;
    
    public RegistrationWindow() {
    registrationFrame = new JFrame("Registration Screen");
    registrationPanel = new JPanel();
    
    usernameField = new JTextField("enter username");
    username = new JLabel("Username: ");
    username.setBounds(50, 200, 80, 30);
    usernameField.setBounds(50,150,200,30);
    
    password = new JLabel("Password: ");
    passwordField = new JPasswordField("enter password");
    passwordField.setBounds(50,150,200,30);
    
    loginButton = new JButton("login");
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(usernameField.getText().equals("user")){
                registrationFrame.dispose();
                new TextEaseGUI();
            } else{
                System.out.println("Error");
            }
        }
    });
    
    ttsButton = new JButton("Text To Speech");
    ttsButton.setBounds(200, 150, 150, 30);
        ttsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextToSpeech tts = new TextToSpeech();
                tts.speak("This is definitley not mario speaking");
            }
        });
        
    
      
    
    registrationPanel.add(username);
    registrationPanel.add(usernameField);
    registrationPanel.add(password);
    registrationPanel.add(passwordField);
    registrationPanel.add(loginButton);
    registrationPanel.add(ttsButton);
    
  
    
    
   
    registrationFrame.add(registrationPanel);
    
    registrationFrame.setSize(300, 150);
    registrationFrame.setLocationRelativeTo(null);
    registrationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    registrationFrame.setVisible(true);
}
}
