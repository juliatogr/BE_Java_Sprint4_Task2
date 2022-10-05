package cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitaController {

	@GetMapping(value ="/HelloWorld")
	public String saluda(@RequestParam String nom) {
		return "Hola, " + nom + ". Estàs executant un projecte Maven";
	}
	
	@GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{nom}"})
	public String saluda2(@PathVariable(name = "nom", required = false) String nom) {
		return "Hola, " + nom + ". Estàs executant un projecte Maven";
	}
}
