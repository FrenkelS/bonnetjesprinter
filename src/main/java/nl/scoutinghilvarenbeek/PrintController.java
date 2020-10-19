package nl.scoutinghilvarenbeek;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrintController {

	@PostMapping("/print")
	public void print(@RequestParam(name = "naam") String naam, @RequestParam(name = "antwoord") String antwoord,
			Model model) {
		model.addAttribute("naam", naam);

		BonnetjesPrinterService bonnetjesPrinterService = new BonnetjesPrinterService();
		bonnetjesPrinterService.print(naam, antwoord);
	}

}
