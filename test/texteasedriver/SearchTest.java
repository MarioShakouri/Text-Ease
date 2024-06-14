package texteasedriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void textSearch() {
        String textToSearch = "This is a sample text for searching.";
        assertTrue(textToSearch.contains("sample"), "Text should contain 'sample'");
        assertFalse(textToSearch.contains("notfound"), "Text should not contain 'notfound'");
    }

    @Test
    void keyPressed() {
        JTextPane textPane = new JTextPane();
        Search search = new Search(textPane);

        KeyEvent validKeyEvent = new KeyEvent(textPane, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, ' ');
        search.keyPressed(validKeyEvent);

        KeyEvent invalidKeyEvent = new KeyEvent(textPane, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ESCAPE, ' ');
        search.keyPressed(invalidKeyEvent);
    }
}
