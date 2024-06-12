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
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //panel with BoxLayout and background color
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new BoxLayout(registrationPanel, BoxLayout.Y_AXIS));
        registrationPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        registrationPanel.setBackground(new Color(159,147,147));

        //username styling
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField(15);
        usernameField.setMaximumSize(usernameField.getPreferredSize());
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Password styling
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField = new JPasswordField(15);
        passwordField.setMaximumSize(passwordField.getPreferredSize());
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Submit button styling
        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(255, 243, 243));
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        //Back button styling
        backButton = new JButton("Back");
        backButton.setBackground(new Color(255,243,243));
        backButton.setFont(new Font("Arial", Font.BOLD,14));
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
        buttonPanel.setBackground(new Color(159, 147, 147));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(submitButton);

        // Add components to panel
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
        pack(); //to adjust frame to fit all components
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void setBackground(Color color) {
        getContentPane().setBackground(color);
    }
}
