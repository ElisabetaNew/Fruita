package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.controllers;

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

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.model.repository.FruitaRepository;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.model.services.FruitaServices;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

	@Autowired
	FruitaServices fruitaServices;

	// http://localhost:8080/fruita/add ---- crear fruta
	@PostMapping("/add")
	public ResponseEntity<Fruita> add(@RequestBody Fruita fruita) {
		try {
			return new ResponseEntity<>(fruitaServices.addFruita(fruita), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8080/fruita/getAll ---- recuperar todas las frutas
	@GetMapping("/getAll")
	public ResponseEntity<Fruita> getAll() {
		try {
			return new ResponseEntity(fruitaServices.getAllFruita(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8080/fruita/getOne/{id} ----- recuperar fruta por id
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getById(@PathVariable("id") int idFruita) {
		try {
			return new ResponseEntity(fruitaServices.getOneFruita(idFruita), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8080/fruita/update ---- actualizar o modificar fruta
	@PutMapping("/update/{id}")
	public ResponseEntity<Fruita> updateTutorial(@PathVariable("id") int idFruita, @RequestBody Fruita fruita) {
		try {
			if (fruitaServices.getOneFruita(idFruita).isPresent()) {
				return new ResponseEntity<Fruita>(fruitaServices.updateFruita(idFruita, fruita), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8080/fruita/delete/{id} ---- borrar fruta por id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteId(@PathVariable("id") int idFruita) {
		try {
			boolean respuesta = fruitaServices.deleteFruita(idFruita);
			if (respuesta == true) {
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}

