package texteasedriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPortalWindow extends JFrame {

    private JFrame registrationFrame;
    private JPanel registrationPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton backButton;

    public RegistrationPortalWindow() {

        registrationFrame = new JFrame("Registration Portal");
        registrationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registrationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        registrationPanel = new JPanel();
        registrationPanel.setLayout(new BoxLayout(registrationPanel, BoxLayout.Y_AXIS));
        registrationPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        registrationPanel.setBackground(new Color(155, 77, 56));

        ImageIcon image = new ImageIcon("TextEaseDriver/src/logo.png");
        Image scaledImage = image.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField(15);
        usernameField.setMaximumSize(new Dimension(500, 50));
        usernameField.setPreferredSize(new Dimension(500, 50));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(new Dimension(500, 50));
        passwordField.setPreferredSize(new Dimension(500, 50));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(91, 100, 118));
        submitButton.setFont(new Font("Arial", Font.BOLD, 25));
        submitButton.setMaximumSize(new Dimension(300, 80));
        submitButton.setPreferredSize(new Dimension(300, 80));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton = new JButton("Back");
        backButton.setBackground(new Color(91, 100, 118));
        backButton.setFont(new Font("Arial", Font.BOLD, 25));
        backButton.setMaximumSize(new Dimension(300, 80));
        backButton.setPreferredSize(new Dimension(300, 80));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (User.createAccount(username, password)) {
                    JOptionPane.showMessageDialog(registrationFrame, "Congrats! Your account was created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    registrationFrame.dispose(); // Dispose the current window
                } else {
                    JOptionPane.showMessageDialog(registrationFrame, "The Account creation failed. Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationFrame.dispose();
                new RegistrationWindow();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(new Color(91, 100, 118));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(submitButton);

        registrationPanel.add(logoLabel);
        registrationPanel.add(usernameLabel);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        registrationPanel.add(usernameField);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        registrationPanel.add(passwordLabel);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        registrationPanel.add(passwordField);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        registrationPanel.add(submitButton);
        registrationPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        registrationPanel.add(backButton);

        registrationFrame.add(registrationPanel);
        registrationFrame.pack();
        registrationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        registrationFrame.setVisible(true);
    }

    public void setBackground(Color color) {
        getContentPane().setBackground(color);
    }
}
