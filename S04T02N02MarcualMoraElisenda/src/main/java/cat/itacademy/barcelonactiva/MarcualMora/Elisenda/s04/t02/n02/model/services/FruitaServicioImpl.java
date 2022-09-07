package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.repository.FruitaRepository;

@Service
public class FruitaServicioImpl implements FruitaServices {

	@Autowired
	private FruitaRepository fruitaRepository;

	@Override
	@Transactional
	public Fruita addFruita(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Fruita> getAllFruita() {

		return fruitaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Fruita> getOneFruita(Integer idFruita) {
		return fruitaRepository.findById(idFruita);
	}

	@Override
	@Transactional
	public Fruita updateFruita(Integer idFruita, Fruita updateFruita) {
		Fruita fruitaBuscada = fruitaRepository.findById(idFruita).get();
		fruitaBuscada.setNom(updateFruita.getNom());
		fruitaBuscada.setQuantitatQuilos(updateFruita.getQuantitatQuilos());
		return fruitaRepository.save(updateFruita);
	}

	@Override
	@Transactional
	public void deleteFruita(Integer idFruita) {
		fruitaRepository.deleteById(idFruita);
	}

}
