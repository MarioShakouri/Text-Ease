package texteasedriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlingTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void autoSaveFunc() {

    }

    @Test
    void saveToFile()  {

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


