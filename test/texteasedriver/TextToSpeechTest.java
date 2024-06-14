package texteasedriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextToSpeechTest {
    private TextToSpeech tts;

    @BeforeEach
    void setUp() {
        tts = new TextToSpeech();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void speak() throws Exception {
        tts.speak("Testing Kevin");
    }
}