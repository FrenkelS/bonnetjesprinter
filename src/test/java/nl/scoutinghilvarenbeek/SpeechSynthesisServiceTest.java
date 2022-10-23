package nl.scoutinghilvarenbeek;

import org.junit.jupiter.api.Test;

/**
 * This class tests {@link SpeechSynthesisService}
 *
 */
class SpeechSynthesisServiceTest {

	@Test
	void textToSpeech() throws Exception {
		SpeechSynthesisService speechSynthesizer = new SpeechSynthesisService();
		speechSynthesizer.textToSpeech("Scouting Bake", "Hello World!");
		speechSynthesizer.textToSpeech("Scouting Bake", "Nog een keertje");
	}
}
