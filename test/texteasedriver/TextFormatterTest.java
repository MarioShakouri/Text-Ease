package texteasedriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import static org.junit.jupiter.api.Assertions.*;

class TextFormatterTest {

    private JTextPane textPane;

    @BeforeEach
    void setUp() {
        textPane = new JTextPane();
        textPane.setText("Test this!");
        textPane.select(0, 4); // Selected "Test"
    }

    @AfterEach
    void tearDown() {
        textPane = null;
    }

    @Test
    void bold() {
        TextFormatter.bold(textPane);
        StyledDocument doc = textPane.getStyledDocument();
        AttributeSet as = doc.getCharacterElement(0).getAttributes();
        assertTrue(StyleConstants.isBold(as), "Selected Text should be BOLDD!");
    }

    @Test
    void italic() {
        TextFormatter.italic(textPane);
        StyledDocument doc = textPane.getStyledDocument();
        AttributeSet as = doc.getCharacterElement(0).getAttributes();
        assertTrue(StyleConstants.isItalic(as), "Selected Text should be ITALIC!");
    }

    @Test
    void underline() {
    }

    @Test
    void fontSize() {
    }
}