package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.services;

import java.util.Optional;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.domain.Fruita;

public interface FruitaServices {
	
	public Fruita addFruita(Fruita fruita);
	
	public Iterable<Fruita> getAllFruita ();
	
	public Optional<Fruita> getOneFruita(Integer idFruita);
	
	public Fruita updateFruita (Integer idFruita, Fruita updateFruita);
	
	public void deleteFruita (Integer idFruita);
	
	/*
	 * http://localhost:8080/fruita/add

	http://localhost:8080/fruita/update

	http://localhost:8080/fruita/delete/{id}

	http://localhost:8080/fruita/getOne/{id}

	http://localhost:8080/fruita/getAll
	 */

}
