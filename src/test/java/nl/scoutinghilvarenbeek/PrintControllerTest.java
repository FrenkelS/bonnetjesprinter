package nl.scoutinghilvarenbeek;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
		String ip = "ip.add.re.ss";
		String bericht = "I pity the fool...";
		Model mockModel = mock(Model.class);

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		when(mockRequest.getRemoteAddr()).thenReturn(ip);
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockRequest));

		// act
		printController.print(naam, bericht, mockModel);

		// assert
		verify(mockModel).addAttribute("naam", naam);
		verify(mockBonnetjesPrinterService).print(naam, ip, bericht);
	}

}
