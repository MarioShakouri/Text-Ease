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
import java.io.File;
import java.awt.Desktop;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;



/**
 *
 * @author hayapirzada
 */
public class TextEaseGUI {

    //Universal varibales are the following for easy access
    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu file, edit, tts;
    private JMenuItem open, save, newFile, cut, copy, paste;
    private JTextArea textArea;
    private JScrollPane scroll;

    
    
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

        textArea = new JTextArea("", 30, 100);
        textArea.setBackground(new Color(240, 239, 235));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scroll = new JScrollPane(textArea);

        panel.setLayout(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);
        frame.add(panel);
        frame.setSize(200, 300);
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
        open.addActionListener(new FileHandling.openFile(textArea));
        //save file (Mario Shakouri)
        save.addActionListener(new FileHandling.saveFile(frame, textArea));
        //new file (Mario Shakouri)
        newFile.addActionListener(new FileHandling.newFile(textArea));
        
         //adding Search feature -Haya
        Search search = new Search(textArea);
    }

}

