package nl.scoutinghilvarenbeek;

import org.junit.jupiter.api.Test;

/**
 * This class tests {@link SpeechSynthesizer}
 *
 */
class SpeechSynthesizerTest {

	@Test
	void textToSpeech() throws Exception {
		SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer();
		speechSynthesizer.textToSpeech("Scouting Bake", "Hello World!");
		speechSynthesizer.textToSpeech("Scouting Bake", "Nog een keertje");
	}

}
