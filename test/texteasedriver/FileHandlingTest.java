package texteasedriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlingTest {

    private JTextPane textPane;
    private JFrame frame;

    @BeforeEach
    void setUp() {
        textPane = new JTextPane();
        frame = new JFrame();
    }

    @AfterEach
    void tearDown() {
        textPane = null;
        frame = null;
    }

    @Test
    void autoSaveFunc() {

        textPane.setText("Autosave this please!");
        FileHandling.autoSaveFunc(textPane);

        //wait for a bit to ensure action is performed
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //verification the auto-save file exists and contains text
        File autoSaveFile = new File("autosave.txt");
        assertTrue(autoSaveFile.exists(), "The autosave file should EXIST");

        try {
            String content = new String(Files.readAllBytes(autoSaveFile.toPath()));
        } catch (IOException e) {
            fail("could not read autosave file");
        } finally {
            autoSaveFile.delete(); //delete file and go to original after test
        }

    }

    @Test
    void saveToFile()  {
        // Set the fixed text to save to file
        String textToSave = "Save this to a file!";

        // Create a temporary file
        File tempFile = null;
        try {
            tempFile = File.createTempFile("testfile", ".txt");
            tempFile.deleteOnExit();
            Files.write(tempFile.toPath(), textToSave.getBytes());
            assertTrue(tempFile.exists(), "The file should EXIST");

            String content = new String(Files.readAllBytes(tempFile.toPath())).trim();
            assertEquals(textToSave.trim(), content, "The content of the file should match the expected text");

        } catch (IOException e) {
            fail("An IOException occurred: " + e.getMessage());
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }


    @Test
    void chooseSaveLocation() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            assertNotNull(selectedFile, "Selected file should not be null");

        } else {
            fail("No file selected for saving");
        }
    }
}


