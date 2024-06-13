/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteasedriver;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author hayapirzada
 */
public class TextEaseGUI {

    //Universal variables are the following for easy access
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu file, edit, tts;
    private JMenuItem open, save, newFile, cut, copy, paste;
    private JTextPane textPane;
    private JButton boldButton, italicButton, underlineButton;
    //private JTextArea textArea;
    private JScrollPane scroll;
    private JComboBox<String> fontSizeCombo;


    //**
    //colors for both the registration and textEditor screen
    //registration screen
    //username and password fields
    //login, create account, tts buttons
    //new window for create account and login button
    //when clicking login button you will access the editor screen
    //JTextArea for writng, JMenuBar and add JMenu to it and JMenu items, tts, autosave, close frame button
    //File menu will have:open,save,new
    //Edit menu will have: cut,copy,paste
    //Constructor for creating all the objects and action listener

    //Components added by-Haya styled by-Mirna
    public TextEaseGUI() {
        frame = new JFrame("TextEase");
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //menuBar to add the file,edit,tts components
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 255, 238));

        file = new JMenu("File");

        edit = new JMenu("Edit");

        tts = new JMenu("TTS");

        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        newFile = new JMenuItem("New");

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");

        //text pane
        textPane = new JTextPane();
        textPane.setBackground(new Color(240, 239, 235));
        textPane.setCaretColor(Color.BLACK);

        //scroll = new JScrollPane(textArea);
        scroll = new JScrollPane(textPane);

        //scroll pane to panel
        panel.add(scroll, BorderLayout.CENTER);
        //scroll panel to frame
        frame.add(panel, BorderLayout.CENTER);

        //toolbar for formatting (buttons)
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Bold button
        boldButton = new JButton("bold!");
        boldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFormatter.bold(textPane);
            }
        });
        toolbar.add(boldButton);


        //italic button
        italicButton = new JButton("Italic!");
        italicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFormatter.italic(textPane);
            }
        });
        toolbar.add(italicButton);


        //underline button
        underlineButton = new JButton("Underline!");
        underlineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFormatter.underline(textPane);
            }
        });
        toolbar.add(underlineButton);

        //font size combo box
        fontSizeCombo = new JComboBox<>(new String[]{"12", "14", "16", "20", "24", "32", "40"});
        fontSizeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = Integer.parseInt((String) fontSizeCombo.getSelectedItem());
                TextFormatter.fontSize(textPane, size);
            }
        });
        toolbar.add(fontSizeCombo);

        panel.add(toolbar, BorderLayout.NORTH);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        file.add(open);
        file.add(save);
        file.add(newFile);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(tts);

        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //open file (Mario Shakouri)
        open.addActionListener(new FileHandling.openFile(textPane));
        // Save file (Mario Shakouri)
        save.addActionListener(new FileHandling.saveFile(frame, textPane));

        //adding Search feature -Haya
        Search search = new Search(textPane);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEaseGUI());
    }

    public JTextPane getTextPane() {
        return textPane;
    }
    public JButton getBoldButton() {
        return boldButton;
    }
}

