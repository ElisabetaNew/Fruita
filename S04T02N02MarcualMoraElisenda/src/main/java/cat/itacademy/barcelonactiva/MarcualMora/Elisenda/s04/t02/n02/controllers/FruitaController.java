package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.services.FruitaServices;

@RestController
@RequestMapping("/fruita")
@CrossOrigin(origins = "http://localhost:8080")
public class FruitaController {

	@Autowired
	private FruitaServices fruitaServices;

	// http://localhost:8080/fruita/add ---- crear fruta
	@PostMapping("/add")
	public ResponseEntity<Fruita> add(@RequestBody Fruita fruita) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(fruitaServices.addFruita(fruita));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// http://localhost:8080/fruita/getAll ---- recuperar todas las frutas
	@GetMapping("/getAll")
	public List<Fruita> getAll() {

		List<Fruita> fruites = StreamSupport.stream(fruitaServices.getAllFruita().spliterator(), false)
				.collect(Collectors.toList());

		return fruites;
	}

	// http://localhost:8080/fruita/getOne/{id} ----- recuperar fruta por id
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int idFruita) {
		Optional<Fruita> oFruites = fruitaServices.getOneFruita(idFruita);

		if (!oFruites.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oFruites);
	}

	// http://localhost:8080/fruita/update ---- actualizar o modificar fruta
	@PutMapping("/update/{id}")
	public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int idFruita, @RequestBody Fruita fruita) {
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
				if (fruitaServices.getOneFruita(idFruita).isPresent()) {
					fruitaServices.deleteFruita(idFruita);
					return ResponseEntity.ok().build();
				} else {
					return ResponseEntity.notFound().build();
				}
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}

	}
}
	

	