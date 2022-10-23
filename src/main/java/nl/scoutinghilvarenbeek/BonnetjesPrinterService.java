package nl.scoutinghilvarenbeek;

import java.time.LocalDateTime;

import javax.speech.AudioException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class BonnetjesPrinterService {

	private final Printer printer;
	private final SpeechSynthesizer speechSynthesizer;

	public BonnetjesPrinterService(Printer printer, SpeechSynthesizer speechSynthesizer) {
		this.printer = printer;
		this.speechSynthesizer = speechSynthesizer;
	}

	public void print(String naam, String bericht) throws AudioException, InterruptedException {
		String name = StringUtils.stripAccents(StringUtils.abbreviate(naam, 40));
		String message = StringUtils.stripAccents(StringUtils.abbreviate(bericht, 80));

		String messageToPrint = "" //
				+ LocalDateTime.now() + "\n" //
				+ name + ":" + "\n" //
				+ message + "\n\n\n\n\n\n\n";

		System.out.println(messageToPrint);

		speechSynthesizer.textToSpeech(name, message);
		printer.print(messageToPrint);
	}

}
