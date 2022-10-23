package nl.scoutinghilvarenbeek;

import java.util.Locale;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SpeechSynthesisService {

	private final Synthesizer synthesizer;

	public SpeechSynthesisService() throws EngineException {
		// Set property as Kevin Dictionary
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

		// Register Engine
		Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");

		// Create a Synthesizer
		this.synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

		// Allocate synthesizer
		synthesizer.allocate();
	}

	public void textToSpeech(String naam, String bericht) throws AudioException, InterruptedException {
		// Resume Synthesizer
		synthesizer.resume();

		// Speaks the given text until the queue is empty.
		synthesizer.speakPlainText(StringUtils.abbreviate(naam, 40), null);
		synthesizer.speakPlainText(StringUtils.abbreviate(bericht, 80), null);
		synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	}

}
