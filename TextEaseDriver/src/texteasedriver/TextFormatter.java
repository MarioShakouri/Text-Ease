package texteasedriver;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextFormatter {

    public static void bold(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        if (start == end) {
            return; // do nothing
        }

        Element element = doc.getCharacterElement(start);
        AttributeSet as = element.getAttributes();

        boolean isBold = StyleConstants.isBold(as);
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBold(sas, !isBold);
        doc.setCharacterAttributes(start, end - start, sas, false);
    }

    public static void italic(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        if (start == end) {
            return; // do nothing
        }
        Element element = doc.getCharacterElement(start);
        AttributeSet as = element.getAttributes();

        boolean isItalic = StyleConstants.isItalic(as);
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setItalic(sas, !isItalic);
        doc.setCharacterAttributes(start, end - start, sas, false);
    }

    public static void underline(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start == end) {
            return; // No selection, do nothing
        }

        Element element = doc.getCharacterElement(start);
        AttributeSet as = element.getAttributes();

        boolean isUnderline = StyleConstants.isUnderline(as);
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setUnderline(sas, !isUnderline);
        doc.setCharacterAttributes(start, end - start, sas, false);
    }

    public static void openWordCountWindow(JTextPane textPane) {
        int wordCount = countWords(textPane.getText());
        JFrame wordCountFrame = new JFrame("Word Count");
        wordCountFrame.setSize(200, 200);
        wordCountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel wordCountDisplayLabel = new JLabel("Word Count: " + wordCount);
        wordCountDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        wordCountFrame.add(wordCountDisplayLabel, BorderLayout.CENTER);
        wordCountFrame.setVisible(true);
    }

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void fontSize(JTextPane textPane, int size) {
        StyledDocument doc = textPane.getStyledDocument();
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        if (start == end) {
            return;
        }

        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontSize(sas, size);
        doc.setCharacterAttributes(start, end - start, sas, false);
    }
}
