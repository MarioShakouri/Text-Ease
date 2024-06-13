package texteasedriver;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;

public class RegistrationPortalWindow extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton backButton;

    public RegistrationPortalWindow() {

        //frame
        setTitle("Registration Portal ");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the window to fit the screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //panel with BoxLayout and background color
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new BoxLayout(registrationPanel, BoxLayout.Y_AXIS));
        registrationPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        registrationPanel.setBackground(new Color(155,77,56));

        // Load the logo image
        ImageIcon image = new ImageIcon("TextEaseDriver/src/logo.png");
        Image scaledImage = image.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //username styling
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField(15);
        usernameField.setMaximumSize(new Dimension(500, 50));
        usernameField.setPreferredSize(new Dimension(500, 50));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Password styling
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 30));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(new Dimension(500, 50));
        passwordField.setPreferredSize(new Dimension(500, 50));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Submit button styling
        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(91, 100, 118));
        submitButton.setFont(new Font("Arial", Font.BOLD, 25));
        submitButton.setMaximumSize(new Dimension(300,80));
        submitButton.setPreferredSize(new Dimension(300,80));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        //Back button styling
        backButton = new JButton("Back");
        backButton.setBackground(new Color(91,100,118));
        backButton.setFont(new Font("Arial", Font.BOLD,25));
        backButton.setMaximumSize(new Dimension(300,80));
        backButton.setPreferredSize(new Dimension(300,80));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        //action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //user input
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                //registration logic
                // for now i only have a message when it registers successfully
                JOptionPane.showMessageDialog(null, "Registration is Successful!");
            }
        });

        //action listener for back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrationWindow();
            }
        });

        // A panel for the button with FlowLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setBackground(new Color(91, 100, 118));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(submitButton);

        // add components to panel
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
        registrationPanel.add(Box.createRigidArea(new Dimension(0,10)));
        registrationPanel.add(backButton);

        //frame setup
        add(registrationPanel);
        setVisible(true);
    }


    public void setBackground(Color color) {
        getContentPane().setBackground(color);
    }
}
