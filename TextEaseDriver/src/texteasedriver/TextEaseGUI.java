/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteasedriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.DefaultEditorKit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author hayapirzada
 */
public class TextEaseGUI {

    //Universal variables are the following for easy access
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu file, edit, shortcut;
    private JMenuItem open, save, newFile, cut, copy, paste, delFile, ctrlF, cmdF;
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

        shortcut = new JMenu("Shortcuts");

        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        newFile = new JMenuItem("New");
        delFile = new JMenuItem("Delete");

        cut = new JMenuItem(new DefaultEditorKit.CutAction());
        copy = new JMenuItem(new DefaultEditorKit.CopyAction());
        paste = new JMenuItem(new DefaultEditorKit.PasteAction());
        
        //set the text
        cut.setText("Cut");
        copy.setText("Copy");
        paste.setText("Paste");
        
        ctrlF = new JMenuItem("Ctrl + F (win):  to search");
        cmdF = new JMenuItem("Cmd + F (macOS): to search");

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

        JButton countButton = new JButton("Word Count");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextFormatter.openWordCountWindow(textPane);
            }
        });
        toolbar.add(countButton);

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
        file.add(delFile);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        
        shortcut.add(ctrlF);
        shortcut.add(cmdF);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(shortcut);

        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //open file (Mario Shakouri)
        open.addActionListener(new FileHandling.openFile(textPane));
        // Save file (Mario Shakouri)
        save.addActionListener(new FileHandling.saveFile(frame, textPane));

        //Add new file(Ricardo Quinonez)
        newFile.addActionListener(new FileHandling.createFile(frame));

        //Delete a file(Ricardo Quinonez)
        delFile.addActionListener(new FileHandling.deleteFile(frame));

        //adding Search feature -Haya
        Search search = new Search(textPane);

        FileHandling.autoSaveFunc(textPane);
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