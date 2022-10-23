package nl.scoutinghilvarenbeek;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import javax.speech.AudioException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

@Service
public class BonnetjesPrinterService {

	private final SpeechSynthesisService speechSynthesizer;

	public BonnetjesPrinterService(SpeechSynthesisService speechSynthesizer) {
		this.speechSynthesizer = speechSynthesizer;
	}

	public void print(String naam, String bericht) throws AudioException, InterruptedException {
		String message = LocalDateTime.now() + "\n" + //
				StringUtils.stripAccents(StringUtils.abbreviate(naam, 40)) + ":\n" + //
				StringUtils.stripAccents(StringUtils.abbreviate(bericht, 80)) + "\n\n\n\n\n\n\n";
		System.out.println(message);

		speechSynthesizer.textToSpeech(naam, bericht);

		byte[] buffer = message.getBytes(StandardCharsets.US_ASCII);

		SerialPort commPort = SerialPort.getCommPort("COM1");
		commPort.openPort();
		commPort.writeBytes(buffer, buffer.length);
		commPort.closePort();
	}

}
