package nl.scoutinghilvarenbeek;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 * This class tests
 *
 */
class BonnetjesPrinterServiceTest {

	@Test
	void print() throws Exception {
		// arrange
		Printer mockPrinter = mock(Printer.class);
		SpeechSynthesizer mockSpeechSynthesizer = mock(SpeechSynthesizer.class);
		BonnetjesPrinterService bonnetjesPrinterService = new BonnetjesPrinterService(mockPrinter,
				mockSpeechSynthesizer);

		String naam = "A Very Very Very Very Very Very Long Name";
		String ip = "ip.add.re.ss";
		String bericht = "A very very very very very very very very very very very very very very long message.";

		// act
		bonnetjesPrinterService.print(naam, ip, bericht);

		// assert
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockPrinter).print(captor.capture());
		String message = captor.getValue();
		assertTrue(message.endsWith("\n" //
				+ "A Very Very Very Very Very Very Long ... (ip.add.re.ss):\n" //
				+ "A very very very very very very very very very very very very very very long ...\n" //
				+ "\n"), message);

		verify(mockSpeechSynthesizer).textToSpeech("A Very Very Very Very Very Very Long ...",
				"A very very very very very very very very very very very very very very long ...");
	}

}
