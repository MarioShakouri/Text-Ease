/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteasedriver;

import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 *
 * @author marioshakouri
 */

public class FileHandling {

    private static String filePath = "autosave.txt";
    private static Timer autoSaveTimer;

    public static void autoSaveFunc(JTextPane textArea) {
        int autoSaveInterval = 60000;
        autoSaveTimer = new Timer(autoSaveInterval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile(filePath, textArea.getText());
            }
        });
        autoSaveTimer.start();
    }

    public static void saveToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void chooseSaveLocation(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }
    
    // openFile Logic (Mario Shakouri)
    public static class openFile implements ActionListener {

        private JTextPane textArea;

        public openFile(JTextPane textArea) {
            this.textArea = textArea;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported");
                return;
            }

            JFileChooser fileChooser = new JFileChooser();

            int result = fileChooser.showOpenDialog(null);
            if (result != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File file = fileChooser.getSelectedFile();

            // Scanner to read file
            try (Scanner scanner = new Scanner(file)) {
                StringBuilder fileContent = new StringBuilder();
                while (scanner.hasNextLine()) {
                    fileContent.append(scanner.nextLine()).append("\n");
                }

                textArea.setText(fileContent.toString());
            } catch (IOException ex) {
                System.out.println("Error reading file: " + ex.getMessage());
            }
        }
    }

    

    // saveFile Logic (Mario Shakouri)
    public static class saveFile implements ActionListener {
        private JFrame frame;
        private JTextPane textArea;

        public saveFile(JFrame frame, JTextPane textArea) {
            this.frame = frame;
            this.textArea = textArea;
        }

        

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                    writer.write(textArea.getText());
                    JOptionPane.showMessageDialog(frame, "File saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    //newFile Logic (Mario Shakouri)
    public static class newFile implements ActionListener {
        private JTextArea textArea;

        public newFile(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to create a new file? Unsaved changes will be lost.", "New File", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                textArea.setText("");
            }
        }
    }


    /**
     * Author
     * Ricardo Quinonez
     *
     */
    public static class createFile implements ActionListener {
        private JFrame frame;
        public createFile(JFrame frame) {
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    if (file.createNewFile()) {
                        JOptionPane.showMessageDialog(frame, "File created successfully: " + file.getName());
                        // change that last line after testing

                    } else {
                        JOptionPane.showMessageDialog(frame, "File already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error creating file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Author
     * Ricardo Quinonez
     *
     */
    public static class deleteFile implements ActionListener {
        private JFrame frame;
        public deleteFile(JFrame frame) {
            this.frame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file.delete()) {
                    JOptionPane.showMessageDialog(frame, "File deleted successfully, YAY IT WORKS!!");
                    // change that last line after testing
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to delete the file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}