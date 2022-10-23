package nl.scoutinghilvarenbeek;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

/**
 * This class tests {@link PrintController}
 *
 */
class PrintControllerTest {

	@Test
	void print() throws Exception {
		// arrange
		BonnetjesPrinterService mockBonnetjesPrinterService = mock(BonnetjesPrinterService.class);
		PrintController printController = new PrintController(mockBonnetjesPrinterService);
		String naam = "Mr. Test";
		String bericht = "I pity the fool...";
		Model mockModel = mock(Model.class);

		// act
		printController.print(naam, bericht, mockModel);

		// assert
		verify(mockModel).addAttribute("naam", naam);
		verify(mockBonnetjesPrinterService).print(naam, bericht);
	}
}
