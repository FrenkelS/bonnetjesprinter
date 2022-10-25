package nl.scoutinghilvarenbeek;

import javax.speech.AudioException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		bonnetjesPrinterService.print(naam, bericht);
	}

}
