/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteasedriver;

import javax.swing.*;
import java.awt.*;
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

    // openFile Logic (Mario Shakouri)
    public static class openFile implements ActionListener {

        private JTextArea textArea;

        public openFile(JTextArea textArea) {
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
        private JTextArea textArea;

        public saveFile(JFrame frame, JTextArea textArea) {
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
}

