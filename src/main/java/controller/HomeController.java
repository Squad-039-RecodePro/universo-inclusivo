package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping
	public String home() {

		return "index";
	}

	@GetMapping("/contato")
	public String contato() {

		return "contato";
	}

	@GetMapping("/sobre")
	public String sobre() {

		return "sobre";
	}
}
