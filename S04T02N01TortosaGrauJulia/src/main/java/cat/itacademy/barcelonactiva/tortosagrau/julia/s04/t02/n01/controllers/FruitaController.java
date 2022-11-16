package cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.repository.FruitaRepository;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

	@Autowired
	FruitaRepository fruitaRepository;

	@GetMapping("/getAll")
	public ResponseEntity<List<Fruita>> getAllFruites() {
		try {
			List<Fruita> fruites = new ArrayList<Fruita>();
		
			fruitaRepository.findAll().forEach(fruites::add);
		
			return new ResponseEntity<>(fruites, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getFruitaById(@PathVariable(name = "id", required = false) int id) {
	Optional<Fruita> fruitaData = fruitaRepository.findById(id);
	
		if (fruitaData.isPresent()) {
			return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/add")
	public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita) {
		try {
			Fruita _fruita = fruitaRepository
					.save(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
			return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
  }

	@PutMapping("/update/{id}")
	public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int id, @RequestBody Fruita fruita) {
		Optional<Fruita> fruitaData = fruitaRepository.findById(id);

		if (fruitaData.isPresent()) {
			Fruita _fruita = fruitaData.get();
			_fruita.setNom(fruita.getNom());
			_fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
			return new ResponseEntity<>(fruitaRepository.save(_fruita), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") int id) {
		try {
			fruitaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
