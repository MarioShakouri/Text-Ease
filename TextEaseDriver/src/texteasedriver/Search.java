/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteasedriver;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author hayapirzada
 */ //developed by Haya
public class Search implements KeyListener {
    private JTextPane textArea;
    private JTextField search;
    private String searchText;
    
    public Search(JTextPane textArea){
        this.textArea = textArea;
    if(this.textArea != null){
        this.textArea.addKeyListener(this);
    }else
        System.out.println("error");
    }
    
    
    public void textSearch(String searchText) throws BadLocationException{
    
    
    
    int length = textArea.getDocument().getLength();
    String text = textArea.getDocument().getText(0, length);
    
    Highlighter highlighter = textArea.getHighlighter();
    Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
    
    //remove previous highlighted text
    highlighter.removeAllHighlights();
    
    int offset = text.indexOf(searchText);
    length = searchText.length();
    while (offset != -1)
    {
        try
        {
            textArea.getHighlighter().addHighlight(offset, offset + length, painter);
            offset = text.indexOf(searchText, offset+1);
        }
        catch(BadLocationException ble){
            System.out.println(ble);
        } 
    
    } 
    
    
    
}

    @Override
    public void keyTyped(KeyEvent e) {
        //nothing
    }

    @Override
    
        
    public void keyPressed(KeyEvent e) {
        String OS = System.getProperty("os.name").toLowerCase();
        if(OS.indexOf("win") >= 0 || (OS.indexOf("mac") >= 0) ){
            if(e.isControlDown() || e.isMetaDown() && e.getKeyCode()==KeyEvent.VK_F ){
                
                searchText = JOptionPane.showInputDialog("Enter search:");
                if(searchText != null && !searchText.isEmpty()){
                try {
                    textSearch(searchText);
                } catch (BadLocationException ble) {
                    System.out.println(ble);
                }
                
            }
            
        } else {
                // Handle the case where searchText is null
                System.out.println("Search text is null.");
            }
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
       // do nothhing
    }
    
        
    
}
