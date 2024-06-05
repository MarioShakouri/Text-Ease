/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package texteasedriver;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author hayapirzada
 */
public class TextToSpeech {
    
     private Voice voice;

    public TextToSpeech() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        voice = VoiceManager.getInstance().getVoice("kevin16");

        if (voice == null) {
            System.out.println("Error in getting voice: kevin16");
        }
    }

    public void speak(String text) {
        if (voice != null) {
            voice.allocate();
            voice.speak(text);
            voice.deallocate();
        }
    }
}

