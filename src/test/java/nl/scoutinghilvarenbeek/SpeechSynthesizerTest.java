package nl.scoutinghilvarenbeek;

import javax.speech.synthesis.Synthesizer;

import org.junit.jupiter.api.Test;
import org.powermock.reflect.Whitebox;

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

		Synthesizer synthesizer = Whitebox.getInternalState(speechSynthesizer, Synthesizer.class);
		synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	}

}
