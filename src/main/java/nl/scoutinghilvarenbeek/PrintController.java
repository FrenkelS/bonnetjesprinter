package nl.scoutinghilvarenbeek;

import javax.servlet.http.HttpServletRequest;
import javax.speech.AudioException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class PrintController {

	private final BonnetjesPrinterService bonnetjesPrinterService;

	public PrintController(BonnetjesPrinterService bonnetjesPrinterService) {
		this.bonnetjesPrinterService = bonnetjesPrinterService;
	}

	@PostMapping("/print")
	public void print(@RequestParam(name = "naam") String naam, @RequestParam(name = "bericht") String bericht,
			Model model) throws AudioException {
		model.addAttribute("naam", naam);

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String ip = request.getRemoteAddr();

		bonnetjesPrinterService.print(naam, ip, bericht);
	}

}
